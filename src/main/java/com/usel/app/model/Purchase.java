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
@Table(name = "PURCHASES")
public class Purchase {

	@OneToMany(mappedBy = "vendor")
	private List<Vendor> items = new LinkedList<Vendor>();

	@OneToMany(mappedBy = "user")
	private List<User> items2 = new LinkedList<User>();

	@OneToMany(mappedBy = "job")
	private List<Job> items3 = new LinkedList<Job>();

	@Id
	@Column(name = "PO")
	@GeneratedValue
	private int po;

	@Column(name = "FINAL_PO_NUMBER")
	private String finalPoNumber;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private int userId;

	@Id
	@Column(name = "JOB_ID")
	@GeneratedValue
	private int jobId;
	
	@Id
	@Column(name = "VENDOR_ID")
	@GeneratedValue
	private int vendorId;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT")
	private boolean updatedAt;

	public Purchase() {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
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

}
