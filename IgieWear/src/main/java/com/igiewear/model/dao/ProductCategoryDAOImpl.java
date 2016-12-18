package com.igiewear.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.igiewear.model.pojo.ProductCategory;

public class ProductCategoryDAOImpl implements ProductCategoryDAO {
	
	@Autowired
	private SessionFactory _sessionFactory;
	  
	private Session getSession() {
	    return _sessionFactory.getCurrentSession();
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory getProductCategory(int productCategoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductCategory(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductCategory(int productCategoryID) {
		// TODO Auto-generated method stub
		
	}

}
