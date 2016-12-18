package com.igiewear.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.igiewear.model.pojo.Product;

public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory _sessionFactory;
	  
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int productID) {
		// TODO Auto-generated method stub
		
	}

}
