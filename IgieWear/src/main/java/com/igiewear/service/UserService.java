package com.igiewear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igiewear.model.dao.UserDAO;
import com.igiewear.model.pojo.User;

@Service
public class UserService {
	
	@Autowired
	public UserDAO userRepository;
	
	
	public List<User> getUsers() {
		return userRepository.getAllUsers();
	}
	
	public void createUser(User user) {
		userRepository.createUser(user);
		return;
	}
}
