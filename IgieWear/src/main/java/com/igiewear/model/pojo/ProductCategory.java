package com.igiewear.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ProductCategory")
public class ProductCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productCategoryID;
	
	@Column(name = "name")
	@NotEmpty(message = "Name should not be empty")
	private String name;

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
