angular.module('app', [])
    .service('SharePropertys', function () {
        var emailUser = '';

        return {
            getEmailUser: function () {
                return emailUser;
            },
            setEmailUser: function(email) {
                emailUser = email;
            }
        };
});