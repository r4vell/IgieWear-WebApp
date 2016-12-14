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

import com.igiewear.model.pojo.Product;
import com.igiewear.service.ProductService;
import com.igiewear.utils.CustomHttpResponseBody;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable(value = "id") int userID) {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<ArrayList<CustomHttpResponseBody>> createUser(@RequestBody Product product) {
		try {
			//userService.createUser(user);
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
	public ResponseEntity<?> updateUser(@RequestBody Product product) {
		//userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser (@PathVariable(value = "id") int productID) {
		//userService.deleteUser(userID);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
	

}
