adminModule.component('adminUserPanel', {
	templateUrl : 'app/admin/user/admin-user.template.html',
	controller: [ 'User',
		function AdminUserPanelController(User, $http) {
		
		var self = this;
		
		self.users = User.query();
    	
		self.registerUser = function() {
	        var user = {
	        		name: self.name,
	        		surname: self.surname,
	        		username: self.username,
	        		password: self.password,
	        		email: self.email,
	        		roleID: 1
	        	};
	        
	        UserService.save(user);
		}
		
		self.getUser = function() {
			User.get({userID : '8'}, function(user) {
				console.log(user);
			});
		}
		
		self.updateUser = function() {
			
			self.currentUser.name = self.modName;
			self.currentUser.surname = self.modSurname;
			self.currentUser.username = self.modUsername;
			self.currentUser.email = self.modEmail;
			self.currentUser.password = self.modPassword;
			User.update(self.currentUser);
			self.users = User.query();
		}
		
		self.deleteUser = function(userData) {
			User.remove({userID: userData.userID});
			self.users = User.query();
		}
		
		self.onTableClick = function(userData) {

			self.currentUser = userData;
			self.modName = userData.name;
			self.modSurname = userData.surname;
			self.modUsername = userData.username;
			self.modEmail = userData.email;
			self.modPassword = userData.password;
			
		}


	}
		
	]
		
})