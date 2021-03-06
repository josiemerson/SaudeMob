(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];
    function config($routeProvider, $locationProvider) {
        $routeProvider
             .when('/', {
                 controller: 'LoginController',
                 templateUrl: 'login/login.view.html',
                 controllerAs: 'vm'
                         })

             .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })
            // .when('/editPerfil', {
            //     controller: 'EditPerfilController',
            //     templateUrl: 'editPerfil/editPerfil.view.html',
            //     controllerAs: 'vm'
            // })
            .when('/login', {
                controller: 'LoginController',
                templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
                        })
            .when('/single', {
                   templateUrl: 'single/index.html',
                   controllerAs: 'vm'
                         })
            .when('/singleespec', {
                   templateUrl: 'singleespec/especialidades.html',
                   controllerAs: 'vm'
                         })
            .when('/singlemapa', {
                   templateUrl: 'singlemapa/map.view.html',
                   controller:  'MapsController',
                   controllerAs: 'vm'
                         })
            .otherwise({ redirectTo: '/login' });
    }

    run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
    function run($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.getObject('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register', '/single', '/singleespec', '/singlemapa', '/editPerfil']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/home');
            }
        });
    }

})();