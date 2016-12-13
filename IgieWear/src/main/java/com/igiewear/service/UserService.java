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
		return userRepository.getUsers();
	}
	
	public User getUser(int userID) {
		return userRepository.getUser(userID);
	}
	
	public void createUser(User user) {
		userRepository.createUser(user);
	}
	
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}
	
	public void deleteUser(int userID) {
		userRepository.deleteUser(userID);
	}
}
