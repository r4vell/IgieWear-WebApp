package com.igiewear.model;


public class User {
	
	public int userID;
	public String username;
	public String name;
	public String surname;
	public int deliveryAddress;
	public String email;
	public String password;
	public String date;
	public boolean isActive;
	public boolean isAdmin;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(int deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "UserID: " + userID + " Username: " + username + " Name: " + name + " Surname: " + surname; 
	}

}
