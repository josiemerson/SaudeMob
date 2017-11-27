(function () {
    'use strict';

    angular
        .module('app')
        .factory('UserService', UserService);

    UserService.$inject = ['$http'];
    function UserService($http) {
        var service = {};

        service.GetAll = GetAll;
        service.GetById = GetById;
        service.GetByUsername = GetByUsername;
        service.GetAllMedicals = GetAllMedicals;
        service.Create = Create;
        service.Update = Update;
        service.Delete = Delete;

        return service;

        function GetAll() {
            return $http.get('http://localhost:8080/user/list').then(handleSuccess, handleError('Error getting all users'));
        }

        function GetAllMedicals(callback) {
            return $http.get('http://localhost:8080/user/list/medicals').then(function successCallback(response) {
                //console.log(response);
                callback(response);  
            }, function errorCallback(response) {
                //console.log(response);
                if (response.status == 409) {
                    response = { success: false, message: 'Não foram encontrados médicos' };
                }
                callback(response); 
            });
        }

        function GetById(id) {
            return $http.get('/api/users/' + id).then(handleSuccess, handleError('Error getting user by id'));
        }

        function GetByUsername(email) {
            return $http.get('http://localhost:8081/users.json' + email).then(handleSuccess, handleError('Error getting user by email'));
        }

        function Create(user, callback) {
            //FUNCIONA, MAS NÃO RETORNA ERROS NEM NADA, APENAS INSERE SE OK
            //return $http.post('http://localhost:8080/user/new', user).then(handleSuccess, handleError('Erro ao criar usuario'));
            
            return $http.post('http://localhost:8080/user/new', user).then(function successCallback(response) {
                //console.log(response);
                if (response.status == 200) {
                    response = { success: true };
                }
                callback(response);  
            }, function errorCallback(response) {
                //console.log(response);
                if (response.status == 409) {
                    response = { success: false, message: 'Email ja cadastrado' };
                }
                callback(response); 
            });
            /*$http({
                method: 'POST',
                url: 'http://localhost:8080/user/new',
                data: { user }
            }).then(function successCallback(response) {
                console.log("ok");
                if (response.status == 200) {
                    response = { success: true };
                }
                callback(response);
            }, function errorCallback() {
                var response = this;
                response = { success: false, message: 'Email ou senha incorreto' };
                callback(response);
            });
            */
        }

        function Update(user) {
            return $http.put('/api/users/' + user.id, user).then(handleSuccess, handleError('Error updating user'));
        }

        function Delete(id) {
            return $http.delete('/api/users/' + id).then(handleSuccess, handleError('Error deleting user'));
        }

        // private functions

        function handleSuccess(res) {
            return res.data;
        }

        function handleError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    }

})();
