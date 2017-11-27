(function () {
    'use strict';

    angular
        .module('app')
        .controller('RegisterController', RegisterController);

    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;

        vm.register = register;
        var autocomplete = null;

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

        function register() {
            vm.dataLoading = true;
            
            UserService.Create(vm.user, function (response){
                if (response.success) {
                        FlashService.Success('Usuario registrado com sucesso', true);
                        $location.path('/login');
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
            
            /* FUNCIONA, MAS SEM CALLBACK
            UserService.Create(vm.user)
                .then(function (response) {
                    if (response.success) {
                        //FlashService.Success('Registration successful', true);
                        //$location.path('/login');
                        $location.path('/');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
            */
        }
    }

})();
