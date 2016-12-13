igiemodule.config(['$stateProvider', '$urlRouterProvider',
    function config($stateProvider, $urlRouterProvider) {
	
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
		.state('product', {
			url: '/product',
			templateUrl: '/app/product-list/product-list.template.html'
		})
		.state('product.detail', {
			url: '/product',
			templateUrl: '/app/product-list/product-list.template.html'
		})
	
	
    }
  ]);