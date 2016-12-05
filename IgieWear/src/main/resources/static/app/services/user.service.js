angular.module('services').
  factory('UserService', ['$resource',
    function($resource) {
      return $resource('/user', {}, {
        query: {
          method: 'GET',
          params: {},
          isArray: true
        },
      	create: {
          method: 'POST',
          params: {},
          isArray: true
        }
      });
    }
  ]);