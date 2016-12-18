package com.igiewear.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igiewear.model.pojo.ProductCategory;
import com.igiewear.service.ProductCategoryService;
import com.igiewear.utils.CustomHttpResponseBody;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@GetMapping
	public List<ProductCategory> getProducts() {
		return productCategoryService.getProductCategories();
	}
	
	@GetMapping("/{id}")
	public ProductCategory getProductCategory(@PathVariable(value = "id") int productCategoryID) {
		return productCategoryService.getProductCategory(productCategoryID);
	}
	
	@PostMapping
	public ResponseEntity<ArrayList<CustomHttpResponseBody>> createUser(@RequestBody ProductCategory productCategory) {
		try {
			productCategoryService.createProductCategory(productCategory);
		}
		catch (ConstraintViolationException e)
		{
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			
			ArrayList<CustomHttpResponseBody> responseBody = new ArrayList<>();
			for ( ConstraintViolation<?> violation : violations ) {
				CustomHttpResponseBody responseBodyElement = new CustomHttpResponseBody(violation.getMessage());
				responseBody.add(responseBodyElement);
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody ProductCategory productCategory) {
		productCategoryService.updateProductCategory(productCategory);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable(value = "id") int productCategoryID) {
		productCategoryService.deleteProductCategory(productCategoryID);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
