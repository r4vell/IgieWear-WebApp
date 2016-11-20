angular.module('igiewear', [])
  .controller('postController',['$scope', '$http', function($scope, $http) {

	  
    $scope.greeting = {id: 'xxx', content: 'Hello World!'};
    $scope.count = 0;
    
    $scope.postData = function (){
    	console.log("SENDING...");
    	var user = { userID: 1, email: "r4vell", name: "damian", surname:"bala", password:"haker123"}
    	$http.post("/user/", user);
    }

    
}])