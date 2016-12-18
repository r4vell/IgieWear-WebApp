package com.igiewear.model.dao;

import java.util.List;

import com.igiewear.model.pojo.Product;

public interface ProductDAO {
	
	public List<Product> getProducts();
	public Product getProduct(int productID);
	public void createProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int productID);

}
