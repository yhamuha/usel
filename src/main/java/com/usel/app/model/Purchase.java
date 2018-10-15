package com.usel.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PURCHASES")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

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
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private boolean updatedAt;
	
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "JOB_ID")
	private int jobId;
	
	@Column(name = "VENDOR_ID")
	private int vendorId;

	public Purchase() {
	}
	
	public Purchase(int po, String finalPoNumber, boolean createdAt, boolean updatedAt, int userId, int jobId, int vendorId) {
		this.po = po;
		this.finalPoNumber = finalPoNumber;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userId = userId;
		this.jobId = jobId;
		this.vendorId = vendorId;
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

	@Override
	public String toString() {
		return "Purchase [vendor=" + vendor + ", user=" + user + ", job=" + job + ", po=" + po + ", finalPoNumber="
				+ finalPoNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", userId=" + userId
				+ ", jobId=" + jobId + ", vendorId=" + vendorId + "]";
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