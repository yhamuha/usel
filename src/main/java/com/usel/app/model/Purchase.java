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
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Purchase {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendor_id", insertable=false, updatable=false)
	private Vendor vendor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable=false)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id", insertable=false, updatable=false)
	private Job job;

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
	
	public Purchase(/*int po,*/ String finalPoNumber, Date createdAt, Date updatedAt /*int userId ,*/ /*int jobId,*//* int vendorId*/) {
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
		return "Purchase [vendor=" + vendor + ", user=" + user + ", job=" + job /*+ ", po=" + po*/ + ", finalPoNumber="
				+ finalPoNumber + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt /*+ ", userId=" + userId*/
				/*+ ", jobId=" + jobId*/ /*+ ", vendorId=" + vendorId*/ + ", getVendor()=" + getVendor() + ", getUser()="
				+ getUser() + ", getJob()=" + getJob() + ", getPo()=" + getPo() + ", getFinalPoNumber()="
				+ getFinalPoNumber() + ", isCreatedAt()=" + isCreatedAt() + ", isUpdatedAt()=" + isUpdatedAt()
				/*+ ", getUserId()=" + getUserId()*/ /*+ ", getJobId()=" + getJobId()*/ /*+ ", getVendorId()=" + getVendorId()*/
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
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