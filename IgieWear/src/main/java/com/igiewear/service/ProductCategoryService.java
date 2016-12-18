package com.igiewear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igiewear.model.dao.ProductCategoryDAO;
import com.igiewear.model.pojo.ProductCategory;

@Service
public class ProductCategoryService {
	
	@Autowired
	public ProductCategoryDAO userRepository;
	
	
	public List<ProductCategory> getProductCategories() {
		return userRepository.getProductCategories();
	}
	
	public ProductCategory getProductCategory(int productCategoryID) {
		return userRepository.getProductCategory(productCategoryID);
	}
	
	public void createProductCategory(ProductCategory productCategory) {
		userRepository.createProductCategory(productCategory);
	}
	
	public void updateProductCategory(ProductCategory productCategory) {
		userRepository.updateProductCategory(productCategory);
	}
	
	public void deleteProductCategory(int productCategoryID) {
		userRepository.deleteProductCategory(productCategoryID);
	}

}
