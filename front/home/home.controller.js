(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope'];
    function HomeController(UserService, $rootScope) {
        var vm = this;

        vm.user = null;
        vm.allUsers = [];
        vm.deleteUser = deleteUser;

        initController();

        function initController() {
            loadCurrentUser();
            loadAllUsers();
        }

        function loadCurrentUser() {
            UserService.GetByUsername($rootScope.globals.currentUser.email)
                .then(function (user) {
                    vm.user = user;
                });
        }

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    }

})();
/*angular.module('app')

    .controller('ProdutoController', function ($scope, $http) {
        $scope.data = new Date();

        $scope.user = [];

        var carregarUsuarios = function () {
            $http.get("http://localhost:8080/user/list").success(function(data, status){
                $scope.user = data;
            }).error(function (data, status) {;
                $scope.message = "Algo deu errado! " + data;
            });
        };

        carregarUsuarios();
    });*/
