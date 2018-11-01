package com.usel.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class User {

	@ManyToOne
	@JoinColumn (name="user_id", nullable = false, insertable=false, updatable=false)
	private Purchase purchase;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "short_name", nullable = false)
	private String shortName;

	@Column(name = "is_enabled", nullable = false, columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType" )
    private boolean isEnabled;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	@Column (name = "user_id", nullable = false)
	private int userId;

	public User() {
	}
	
	public User(int id, String name, String lastName, String email, String password, String shortName, boolean isEnabled, 
			    Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.shortName = shortName;
		this.isEnabled = isEnabled;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Date isCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date isUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", shortName=" + shortName + ", isEnabled=" + isEnabled + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
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
