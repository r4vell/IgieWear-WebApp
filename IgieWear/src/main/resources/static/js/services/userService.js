igiemodule.service('UserService', function($http) {
   
   this.registerUser = function (userData) {
	   return $http.post('/user/', userData);
   }
   
   this.getAllUsers = function () {
	   return $http.get('/user/');
   }

})