package com.usel.app.model;

import java.util.Date;
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
@Table(name = "JOBS")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Job {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "DUE_DATE")
	private String dueDate;

	@Column(name = "M_S_SALE")
	private String mSSale;

	@Column(name = "STATUS")
	private boolean status;
	
	/*@Column(name = "CUSTOMER_ID")
	private int customerId;*/
	
	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
	private Date updatedAt;

	@Column(name = "PO_ID")
	private int poId;

	public Job() {
	}

	public Job(int id, String description, String dueDate, String mSSale, boolean status/*, int customerId*/, boolean createdAt, Date updatedAt, int poId) {
		this.id=id;
		this.description=description;
		this.dueDate=dueDate;
		this.mSSale=mSSale;
		this.status=status;
		//this.customerId=customerId;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		this.poId=poId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getmSSale() {
		return mSSale;
	}

	public void setmSSale(String mSSale) {
		this.mSSale = mSSale;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/*public int getCustomerId() {
		return customerId;
	}
 	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}*/
	
	public boolean isCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(boolean createdAt) {
		this.createdAt = createdAt;
	}

	public Date isUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
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
		return "Job [customer=" + customer + ", id=" + id + ", description=" + description + ", dueDate=" + dueDate
				+ ", mSSale=" + mSSale + ", status=" + status /*+ ", customerId=" + customerId*/ + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", poId=" + poId + ", getCustomer()=" + getCustomer()
				+ ", getId()=" + getId() + ", getDescription()=" + getDescription() + ", getDueDate()=" + getDueDate()
				+ ", getmSSale()=" + getmSSale() + ", isStatus()=" + isStatus() /*+ ", getCustomerId()=" + getCustomerId()*/
				+ ", isCreatedAt()=" + isCreatedAt() + ", isUpdatedAt()=" + isUpdatedAt() + ", getPoId()=" + getPoId()
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
        Job e = (Job) o;
        return (this.getId() == e.getId());
    }
	
}
