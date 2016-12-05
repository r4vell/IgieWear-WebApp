igiemodule.service('UserService', function($http) {
   
   this.registerUser = function (userData) {
	   return $http.post('/user/', userData);
   }
   
   this.updateUser = function (userData) {
	   return $http.patch('/user/', userData);
   }
   
   this.deleteUser = function (userData) {
	   return $http.delete('/user/', userData);
   }
   
   this.getAllUsers = function () {
	   return $http.get('/user/');
   }

})