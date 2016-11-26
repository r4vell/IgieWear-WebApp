package com.igiewear.model.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.igiewear.model.pojo.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory _sessionFactory;
	  
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	}

	@Override
	public void createUser(User user) {
		getSession().save(user);
		System.out.println(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<User> allUsers =  getSession().createCriteria(User.class).list();
		return allUsers;
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
