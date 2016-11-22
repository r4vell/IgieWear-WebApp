package com.igiewear.model.dao;

import java.util.List;

import com.igiewear.model.pojo.User;

public interface UserDAO {
	
	public void createUser(User user);
	public boolean updateUser(User user);
	public List<User> getAllUsers();
	public void deleteUser(User user);

}
