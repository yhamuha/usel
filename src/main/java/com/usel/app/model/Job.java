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
@Table(name = "jobs")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Job {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id", insertable=false, updatable=false)
	private Customer customer;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;

	@Column(name = "m_s_sale")
	private String mSSale;

	@Column(name = "status", nullable = false)
	private boolean status;
	
	/*@Column(name = "CUSTOMER_ID")
	private int customerId;*/
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updatedAt")
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;

	//@Column(name = "PO_ID")
	//private int poId;

	public Job() {
	}

	public Job(/*int id,*/ String description, Date dueDate, String mSSale, boolean status/*, int customerId*/, Date createdAt, Date updatedAt/*, int poId*/) {
		//this.id=id;
		this.description=description;
		this.dueDate=dueDate;
		this.mSSale=mSSale;
		this.status=status;
		//this.customerId=customerId;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		//this.poId=poId;
	}

	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}*/

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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
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

	/*public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}*/

	@Override
	public String toString() {
		return "Job [customer=" + customer + ", id=" + id + ", description=" + description + ", dueDate=" + dueDate
				+ ", mSSale=" + mSSale + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((mSSale == null) ? 0 : mSSale.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		Job other = (Job) obj;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (mSSale == null) {
			if (other.mSSale != null)
				return false;
		} else if (!mSSale.equals(other.mSSale))
			return false;
		if (status != other.status)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

}
