angular.module('hello', [])
  .controller('home', function($scope) {

  	
    $(document).ready(function(){
      $('.parallax').parallax();
    });
        

    $scope.greeting = {id: 'xxx', content: 'Hello World!'}
    $scope.message = "HELLO!!!!"
})