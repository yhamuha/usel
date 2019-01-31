package com.usel.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "purchases")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Purchase {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", insertable=false, updatable=false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendor_id", insertable=false, updatable=false)
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", insertable=false, updatable=false)
	private Customer customer;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po")
	private int po;

	@Column(name = "final_po_number", nullable = false)
	private String finalPoNumber;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	/*@Column(name = "USER_ID", nullable = false)
	private int userId;*/
	
 	/*@Column(name = "JOB_ID", nullable = false)
	private int jobId;*/
	
	/*@Column(name = "VENDOR_ID", nullable = false)
	private int vendorId;*/
	
	public Purchase() {
	}
	
	
	public Purchase(/*int po,*/ User user, Customer customer, Vendor vendor, String finalPoNumber, Date createdAt, Date updatedAt /*int userId ,*/ /*int jobId,*//* int vendorId*/) {
		//this.po = po;
		this.finalPoNumber = finalPoNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		//this.userId = userId;
		//this.jobId = jobId;
		//this.vendorId = vendorId;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	/*public int getUserId() {
		return userId;
	}
 	public void setUserId(int userId) {
		this.userId = userId;
	}*/
 	
 	/*public int getJobId() {
		return jobId;
	}
 	
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}*/
 	
 	/*public int getVendorId() {
		return vendorId;
	}
 	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}*/
	
	@Override
	public String toString() {
		return "Purchase [user=" + user + ", vendor=" + vendor + ", customer=" + customer + ", po=" + po
				+ ", finalPoNumber=" + finalPoNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((finalPoNumber == null) ? 0 : finalPoNumber.hashCode());
		result = prime * result + po;
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (finalPoNumber == null) {
			if (other.finalPoNumber != null)
				return false;
		} else if (!finalPoNumber.equals(other.finalPoNumber))
			return false;
		if (po != other.po)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		return true;
	}
	
}