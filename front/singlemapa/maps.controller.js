angular
.module('app')
.controller('MapsController', MapsController);

MapsController.$inject = ['$scope', 'UserService'];
    function MapsController( $scope, UserService){
        var self = this;

		self.initMap = initMap;
        self.refresh = refresh;
		self.tracarRota = tracarRota;
		self.map;

        var myPosition = null;
		var markers = [];
		var directionsDisplay = null;

		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom: 14
			});

			self.map = map;

			refreshMarkersInMap();
		}

		function refresh(){
			markers = [];

			cleanRotesInMap();

			self.map.setZoom(14);

			removeMarkers();

			refreshMarkersInMap();			
		}

		function cleanRotesInMap(){
			if(typeof directionsDisplay != "undefined"){
				directionsDisplay.setDirections(null)
				directionsDisplay.setMap(null);
			}
		}

		function getImagem(isMedico){
			var image = {
				//url: "../res/sit_marron.png", // url
				url: (isMedico ? "../img/med.png" : "../img/eu.jpg"), // url
				scaledSize: new google.maps.Size(50, 50), // scaled size
				origin: new google.maps.Point(0,0), // origin
				anchor: new google.maps.Point(0, 0) // anchor
			};
			return image;
		}

		function getPosition(allMedicals){
			var image = getImagem(true);
			var response = [];

			allMedicals.forEach(function(item, index){
				var latLng = item.coordinates.split(",");

				response.push({name : item.name
				,especialty: item.office
				,valueMedicalConsultation: "120.00"
				,location:{lat : parseInt(latLng[0]), lng: parseInt(latLng[1])}
				,image :image
				,atendimento: "08 às 18hrs"
				,diasAtendimento: "Segunda a Sábado"
				,fone: "(34) 3200-00" + index + "" + index
				,email: item.email
				})
			});

			response.push(
					{name : "Raimundo"
					,especialty: "Clinico Geral"
					,valueMedicalConsultation: "120.00"
					,location:{lat : -18.921, lng: -48.319}
					,image :image
					,atendimento: "08 às 18hrs"
					,diasAtendimento: "Segunda a Sábado"
					,id: 1
					,fone: "(34) 3200-0087"
					,email: "raimundo@gmail.com"
					});
			response.push(
					{name : "Josefa"
					,especialty: "Pneumologista"
					,valueMedicalConsultation: "150.00"
					,location:{lat : -18.921, lng :-48.330}
					,image :image
					,atendimento: "09 às 17hrs"
					,diasAtendimento: "Segunda a Sábado"
					,id: 2
					,fone: "(34) 3234-7487"
					,email:"josefa@gmail.com"
					});
			response.push(						
					{name : "Rui"
					,especialty: "Neurologista"
					,valueMedicalConsultation: "150.00"
					,location:{lat : -18.925, lng :-48.330}
					,image :image
					,atendimento: "08:30 às 17:30hrs"
					,diasAtendimento: "Segunda a Sábado"
					,id: 3
					,fone: null
					,email:"rui@gmail.com"
					});

			return response;
		}

		function refreshMarkersInMap(){
			var map = self.map;

			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(function(position) {
					myPosition = {
						lat: position.coords.latitude,
						lng: position.coords.longitude
					};

					map.setCenter(myPosition);

					var image = getImagem(false);
					var my = {	location : myPosition };

					markers[markers.length + 1] = addCommonMarker(my, map);		
				}, function() {
					handleLocationError(true);
				});
			} else {
				handleLocationError(false);
			}

			UserService.GetAllMedicals(function callback(response){
				if (response.status == 200) {
					addMarker(getPosition(response.data), map);
				} else {
					FlashService.Error(response.message);
					vm.dataLoading = false;
				}
			});
		}

		function addMarker(markersResponse, map){
			var infowindow = new google.maps.InfoWindow({
			});

			map.addListener('click', function(event) {
				infowindow.close();
			});

			function contentString(item){
				var contentString = '<div id="content">'+
				'<h4 id="firstHeading" class="firstHeading">Dr(a): '+ item.name +'</h4>'+
					'<div id="bodyContent">'+
					'<p><b>Especialidade: </b> ' + item.especialty +
					'<p><b>Atendimento: </b>'+ item.atendimento +
					'<p><b>Dias da semana: </b>'+ item.diasAtendimento ;

					if(item.fone != null || item.email != null) {
						contentString = contentString + '<p><b>Contatos</b>'; 
						if(item.fone != null){
						contentString = contentString + '<p><b>Fone: </b>'+ item.fone;
						}
						if(item.email != null){
							contentString = contentString + '<p><b>E-mail: </b>'+ item.email;
						}
					}

					contentString = contentString + '</div>'+'</div>';

				return contentString;
			}

			markersResponse.forEach(function(item, index){
				var marker = addCommonMarker(item, map);				

				markers[index] = marker;

				marker.addListener('click', function(event) {
					infowindow.setContent(contentString(item));
					infowindow.open(map, marker);
					tracarRota(new dadosRota(myPosition, map, marker));
				});
			});
		}

		function addCommonMarker(item, map){
			var objectMarker = {
				  position: item.location,
				  map: map,
				  title: (typeof item.especialty == "undefined" ? 
							  (typeof item.name == "undefined" ? "" : item.name) : 
							  	'Dr(a): ' + item.name + ', Especialidade: ' + item.especialty) + '',
			};

			if(typeof item.image != "undefined"){
				objectMarker.icon = item.image;
			}

			var marker = new google.maps.Marker(objectMarker);

			return marker;
		}

		function removeMarkers(){
			setMapOnAll(null);
		}

		function setMapOnAll(map) {
			markers.forEach(function(marker, index){
				marker.setMap(map);
			});
		}

		function dadosRota(origin, map, marker){
			this.origin = origin;
			this.map = map;
			this.marker = marker;
		}

		function tracarRota(dadosRota){
			removeMarkers();

			directionsDisplay = new google.maps.DirectionsRenderer();
			var directionsService = new google.maps.DirectionsService;

			var request = {
				origin: dadosRota.origin,
				destination: dadosRota.marker.getPosition(),
				travelMode: google.maps.DirectionsTravelMode.DRIVING
			};

			directionsService.route(request, function(response, status) {
				if (status == google.maps.DirectionsStatus.OK) {
					directionsDisplay.setDirections(response);
					directionsDisplay.setMap(dadosRota.map);
				}
			});
		}

		function handleLocationError(browserHasGeolocation) {
			window.alert(browserHasGeolocation ?
							  'Error: The Geolocation service failed.' :
							  'Error: Your browser doesn\'t support geolocation.');
        }

        google.maps.event.addDomListener(window, 'load',self.initMap());        
    }