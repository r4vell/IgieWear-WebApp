package com.igiewear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igiewear.model.User;
import com.igiewear.model.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	public UserDAO userRepository;
	
	
	public String getUsers() {
		return "USER DATA";
	}
	
	public boolean createUser(User user) {
		userRepository.createUser(user);
		return true;
	}
}
