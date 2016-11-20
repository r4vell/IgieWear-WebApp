package com.igiewear.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.igiewear.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Override
	public void createUser(User user) {
		System.out.print("USER CREATED!!!");
		
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
