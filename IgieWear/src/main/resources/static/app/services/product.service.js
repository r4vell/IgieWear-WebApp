angular.module('services').
  factory('Product', ['$resource',
    function($resource) {
      return $resource('/product/:productID', {productID : '@productID'}, {
    	  'update' : { method: 'PUT' }
      });
    }
  ]);