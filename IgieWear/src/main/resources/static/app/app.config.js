igiemodule.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
    function config($stateProvider, $urlRouterProvider, $locationProvider) {
	
		//$locationProvider.html5Mode(true);
		$urlRouterProvider.otherwise('/home');

		$stateProvider
		.state('home', {
			url: '/home',
			templateUrl: '/app/home/home.template.html'
		})
		.state('admin', {
			url: '/admin',
			templateUrl: '/app/admin/admin.template.html',
	        views: {
	            '': { templateUrl: '/app/admin/admin.template.html' },
	            'news@admin': { template: 'Look I am a column!' },
	            'user@admin': { 
	            	template: '<admin-user-panel></admin-user-panel>'
	            },
	            'product@admin': { 
	            	template: '<admin-product-panel></admin-product-panel>'
	            },
	        }
		})
	
	
    }
  ]);