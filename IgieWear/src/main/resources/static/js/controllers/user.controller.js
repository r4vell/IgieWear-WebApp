igiemodule.controller('UserController', function($scope, $http, UserService) {
   
    this.registerUser = function () {

        if($scope.password != $scope.password_conf) {
            Materialize.toast("Passwords do not match", 3000);
            return;
        }
    	
        var userData = {
    		name: $scope.name,
    		surname: $scope.surname,
    		username: $scope.username,
    		password: $scope.password,
    		email: $scope.email,
    		roleID: 1
    	};

    	var promise = UserService.registerUser(userData);

        promise.then(function(response) {
            Materialize.toast("User Created", 3000);
        },
        function(error) {
            for( var messages in error) {
                var item = error[messages];
                for (var text in item) {
                    console.log(item[text].message);
                }
            }
            Materialize.toast("User not created: " + error, 3000);
        })
    }
    
    $scope.updateUser = function() {
    	
    	
    }
    
    
    $scope.deleteUser = function() {
    	
    }
    

    $scope.getAllUsers = function() { 	
    	var promise = UserService.getAllUsers();
    	
        promise.then(function(response) {
        	$scope.users = response.data;
        },
        function(error) {
            Materialize.toast("Error in fetching users" + error, 3000);
        })	
    }
    $scope.getAllUsers();
    
    $scope.onTableClick = function(user) {
		$scope.nameUpdate = user.name;
		$scope.surnameUpdate = user.surname;
		$scope.usernameUpdate = user.username;
		$scope.emailUpdate = user.email;
    }
    

    
    
})