package com.igiewear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igiewear.model.dao.ProductDAO;
import com.igiewear.model.pojo.Product;

@Service
public class ProductService {
	
	@Autowired
	public ProductDAO productRepository;
	
	
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}
	
	public Product getProduct(int productID) {
		return productRepository.getProduct(productID);
	}
	
	public void createProduct(Product product) {
		productRepository.createProduct(product);
	}
	
	public void updateProduct(Product product) {
		productRepository.updateProduct(product);
	}
	
	public void deleteProduct(int productID) {
		productRepository.deleteProduct(productID);
	}

}
