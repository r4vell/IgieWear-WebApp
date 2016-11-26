igiemodule.service('UserService', function($http) {
   
   this.registerUser = function (userData) {
	return $http.post('/user/', userData);
   }

})