package com.igiewear.model.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column(name = "username", unique = true)
	@NotEmpty(message = "Username should not be empty")
	private String username;
	
	@Column(name = "name")
	@NotEmpty(message = "Name should not be empty")
	private String name;
	
	@Column(name = "surname")	
	@NotEmpty(message = "Surname should not be empty")
	public String surname;

	@Column(name = "email")
	@Size(min = 5, max = 255, message = "Email should not be empty")
	private String email;

	@Column(name = "password")
	@NotEmpty(message = "Password should not be empty")
	@Size(min = 8)
	private String password;
	
	@CreationTimestamp
	@Column(name = "dateCreated")
	private Date dateCreated;
	
	@NotNull
	@Column(name = "isActive")
	private boolean isActive;
	
	@NotNull
	@Column(name = "isAdmin")
	private boolean isAdmin;
	
	@NotNull
	@Column(name = "roleID", columnDefinition="default 1")
	private int roleID;
	

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
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public void setDateCreated(Date date) {
		this.dateCreated = date;
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
	
	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	@Override
	public String toString() {
		return "UserID: " + userID + " Username: " + username + " Name: " + name + 
				" Surname: " + surname + " Email: " + email + 
				" Admin: " + isAdmin + " Active: " + isActive; 
	}

}
