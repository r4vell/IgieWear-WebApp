angular.module('igiewear', [])
  .controller('postController',['$scope', '$http', function($scope, $http) {

	  
    $scope.greeting = {id: 'xxx', content: 'Hello World!'};
    $scope.count = 0;
    
    $scope.postData = function (){
    	console.log("SENDING...");
    	$http.post("/", "POST DATA");
    }

    
}])