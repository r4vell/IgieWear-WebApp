igiemodule.config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
      $locationProvider.hashPrefix('!');

      $routeProvider.
      	when('/home', {
          templateUrl: 'home.html'
        }).    
        when('/products', {
          templateUrl: 'products.html'
        }).    
        when('/user', {
          templateUrl: 'user.html'
        }).
        when('/admin', {
            template: '<admin-panel></admin-panel>'
        }).
        otherwise('/home');
    }
  ]);