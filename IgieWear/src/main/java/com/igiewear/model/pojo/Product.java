package com.igiewear.model.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;
	
	@Column(name = "name")
	@NotEmpty(message = "Name should not be empty")
	private String name;

	@Column(name = "description")
	@NotEmpty(message = "Description should not be empty")
	private String description;

	@Column(name = "price")
	@NotNull(message = "Price should not be empty")
	private float price;

	@NotNull
	@Column(name = "productCategoryID", columnDefinition="default 1")
	private int productCategoryID;
	
	@Column(name = "picturePath1")
	@NotEmpty(message = "Picture path should not be empty")
	private String picturePath1;
	
	@Column(name = "picturePath2")
	@NotEmpty(message = "Picture path should not be empty")
	private String picturePath2;
	
	@Column(name = "picturePath3")
	@NotEmpty(message = "Picture path should not be empty")
	private String picturePath3;
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getPicturePath1() {
		return picturePath1;
	}

	public void setPicturePath1(String picturePath1) {
		this.picturePath1 = picturePath1;
	}

	public String getPicturePath2() {
		return picturePath2;
	}

	public void setPicturePath2(String picturePath2) {
		this.picturePath2 = picturePath2;
	}

	public String getPicturePath3() {
		return picturePath3;
	}

	public void setPicturePath3(String picturePath3) {
		this.picturePath3 = picturePath3;
	}

}
