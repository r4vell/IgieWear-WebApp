igiemodule.controller('UserController', function($scope, $http, UserService) {
   
    $scope.registerUser = function () {
    	console.log("SENDING...");

        if($scope.password != $scope.password_conf) {
            Materialize.toast("Passwords do not match", 8000);
            return;
        }
    	
        var userData = {
    		name: $scope.name,
    		surname: $scope.surname,
    		username: $scope.username,
    		password: $scope.password,
    		email: $scope.email
    	};

    	var promise = UserService.registerUser(userData);

        promise.then(function(response) {
            Materialize.toast("User Created", 8000);
        },
        function(error) {
            for( var messages in error) {
                var item = error[messages];
                for (var text in item) {
                    console.log(item[text].message);
                }
            }
            Materialize.toast("User not created: " + error, 8000);
        })
    }

    
})