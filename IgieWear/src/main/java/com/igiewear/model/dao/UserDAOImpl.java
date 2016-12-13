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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return getSession().createCriteria(User.class).list();
	}
	
	@Override
	public User getUser(int userID) {
		return (User) getSession().get(User.class, userID);
	}

	@Override
	public void createUser(User user) {
		getSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}


	@Override
	public void deleteUser(int userID) {
		Session session = getSession();
		User usr = (User) session.get(User.class, userID);
		session.delete(usr);
		session.flush();
	}



}
