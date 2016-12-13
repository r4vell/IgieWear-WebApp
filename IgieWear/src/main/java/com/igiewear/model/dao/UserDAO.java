package com.igiewear.model.dao;

import java.util.List;

import com.igiewear.model.pojo.User;

public interface UserDAO {
	
	public List<User> getUsers();
	public User getUser(int userID);
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(int userID);

}
