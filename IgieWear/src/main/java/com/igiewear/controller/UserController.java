package com.igiewear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igiewear.model.pojo.User;
import com.igiewear.service.UserService;

@RestController
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getUsers(Integer userID) {
		return userService.getUsers();
	}
	
	@PostMapping
	public boolean createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	

}
