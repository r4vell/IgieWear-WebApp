angular.module('services').
  factory('User', ['$resource',
    function($resource) {
      return $resource('/user/:userID', {userID : '@userID'}, {
    	  'update' : { method: 'PUT' }
      });
    }
  ]);