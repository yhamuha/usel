package com.usel.app.model;

public class User {
	
	private int id;
	private int name;
	private int lastName;
	private int email;
	private int password;
	private int shortName;
	private int auth_status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getLastName() {
		return lastName;
	}
	public void setLastName(int lastName) {
		this.lastName = lastName;
	}
	public int getEmail() {
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getShortName() {
		return shortName;
	}
	public void setShortName(int shortName) {
		this.shortName = shortName;
	}
	public int getAuth_status() {
		return auth_status;
	}
	public void setAuth_status(int auth_status) {
		this.auth_status = auth_status;
	}
}


