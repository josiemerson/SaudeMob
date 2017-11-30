(function () {
    'use strict';

    angular
        .module('app')
        .controller('EditPerfilController', EditPerfilController);

    EditPerfilController.$inject = ['UserService', '$location', '$rootScope', 'FlashService', 'SharePropertys'];
    function EditPerfilController(UserService, $location, $rootScope, FlashService, SharePropertys) {
        var vm = this;

        vm.edit = edit;
        var autocomplete = null;

        getUser();

        function getUser(){
            UserService.GetByUserPerEmail(SharePropertys.getEmailUser(), function (response){
                if (response.success) {
                    vm.user.name = response.user.name;
                    vm.user.birthDate = response.user.birthDate;
                    vm.user.email = response.user.email;
                    vm.user.password = response.user.password;
                    vm.user.address = response.user.address;
                    $location.path('/single');
                } else {
                    FlashService.Error("Houve um erro no momento de buscar o seu usuário no banco, entre em contato com 'Saude Mobile'");
                    vm.dataLoading = false;
                }
            });
        }

        locationUser();

        function locationUser(){
            autocomplete = new google.maps.places.Autocomplete((document.getElementById('location')),{types: ['geocode']});

            autocomplete.addListener('place_changed', fillInAddress);
        }

        function fillInAddress(){
            var place = autocomplete.getPlace();
            var userLocation = "undefined";

            if (typeof place.geometry == "undefined") {
                window.alert("Não foi possível localizar seu endereço! Tente novamente mais tarde ou entre em contato com Saude Mobile");
            } else {
                var location = place.geometry.location;
                userLocation = location.lat() + "," + location.lng();
            }

            vm.user.coordinates = userLocation;
        }

        function edit() {
            vm.dataLoading = true;
            
            UserService.GetByUserPer(vm.user, function (response){
                if (response.success) {
                        FlashService.Success('Usuario registrado com sucesso', true);
                        $location.path('/login');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        }
    }

})();
