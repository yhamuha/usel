package com.usel.app.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@OneToMany(mappedBy = "user")
	private List<User> users = new LinkedList<User>();
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private int name;

	@Column(name = "LAST_NAME")
	private int lastName;

	@Column(name = "EMAIL")
	private int email;

	@Column(name = "PASSWORD")
	private int password;

	@Column(name = "SHORT_NAME")
	private int shortName;

	@Column(name = "IS_ENABLED")
	private boolean isEnabled;

	@Column(name = "CREATED_ID")
	private boolean createdAt;

	@Column(name = "UPDATED_ID")
	private boolean updatedAt;

	@Column(name = "PO_ID")
	private int poId;

	public User() {
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

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

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(boolean createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(boolean updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	@Override
	public String toString() {
		return "User [users=" + users + ", id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", shortName=" + shortName + ", isEnabled=" + isEnabled + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", poId=" + poId + "]";
	}

}
