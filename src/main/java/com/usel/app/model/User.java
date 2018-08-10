package com.usel.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PO_ID")
	private User user;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private int userId;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

}
