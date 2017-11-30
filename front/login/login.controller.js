(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService', 'SharePropertys'];
    function LoginController($location, AuthenticationService, FlashService, SharePropertys) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.email, vm.password, function (response) {
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.email, vm.password);
                    window.localStorage.setItem('email', vm.email);
                    
                    //Compartilhar propertys entre controllers
                    SharePropertys.setEmailUser(vm.email);
                    window.location.replace("http://127.0.0.1:8081/#/single");
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }

})();
