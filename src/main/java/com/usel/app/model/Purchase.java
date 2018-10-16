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
@Table(name = "PURCHASES")

public class Purchase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VENDOR_ID")
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID")
	private Job job;

	@Id
	@Column(name = "PO")
	@GeneratedValue
	private int po;

	@Column(name = "FINAL_PO_NUMBER", nullable = false)
	private String finalPoNumber;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private boolean updatedAt;
	
	public Purchase() {
	}
	
	public Purchase(int po, String finalPoNumber, boolean createdAt, boolean updatedAt, int userId, int jobId, int vendorId) {
		this.po = po;
		this.finalPoNumber = finalPoNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
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

	@Override
	public String toString() {
		return "Purchase [vendor=" + vendor + ", user=" + user + ", job=" + job + ", po=" + po + ", finalPoNumber="
				+ finalPoNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +  "]";
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