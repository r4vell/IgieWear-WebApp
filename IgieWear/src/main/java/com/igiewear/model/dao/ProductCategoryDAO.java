package com.igiewear.model.dao;

import java.util.List;

import com.igiewear.model.pojo.ProductCategory;

public interface ProductCategoryDAO {
	
	public List<ProductCategory> getProductCategories();
	public ProductCategory getProductCategory(int productCategoryID);
	public void createProductCategory(ProductCategory productCategory);
	public void updateProductCategory(ProductCategory productCategory);
	public void deleteProductCategory(int productCategoryID);

}
