package com.usel.app.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "purchases")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Purchase {

	@OneToMany(mappedBy = "purchase") 
	private Set<User> users;
	
	@OneToMany(mappedBy = "purchase") 
	private Set<Vendor> vendors;
	
	@OneToMany(mappedBy = "purchase") 
	private Set<Customer> customers;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po")
	private int po;

	@Column(name = "final_po_number", nullable = false)
	private String finalPoNumber;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	public Purchase() {
	}
	
	public Purchase(String finalPoNumber, Date createdAt, Date updatedAt) {
		this.finalPoNumber = finalPoNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Set<Vendor> getVendor() {
		return vendors;
	}

	public void setVendor(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Set<User> getUser() {
		return users;
	}

	public void setUser(Set<User> users) {
		this.users = users;
	}

	public Set<Customer> getCustomer() {
		return customers;
	}

	public void setCustomer(Set<Customer> customers) {
		this.customers = customers;
	}

	public int getPo() {
		return po;
	}

	public void setPo(int po) {
		this.po = po;
	}

	public String getFinalPoNumber() {
		return finalPoNumber;
	}

	public void setFinalPoNumber(String finalPoNumber) {
		this.finalPoNumber = finalPoNumber;
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
		return "Purchase [vendor=" + vendors + ", user=" + users + ", customer=" + customers + ", po=" + po
				+ ", finalPoNumber=" + finalPoNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
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
        Purchase e = (Purchase) o;
        return (this.getPo() == e.getPo());
    }
	
}