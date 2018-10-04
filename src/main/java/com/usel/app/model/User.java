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
	private String name;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "SHORT_NAME")
	private String shortName;

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
	
	public User(int id, String name, String lastName, String email, String password, String shortName, boolean isEnabled, 
			    boolean createdAt, boolean updatedAt, int poId) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.shortName = shortName;
		this.isEnabled = isEnabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.poId = poId;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
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
	
	@Override
	public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if (o == this) {
           return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        User e = (User) o;
        return (this.getId() == e.getId());
    }

}
