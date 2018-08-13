package com.usel.app.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Job {

	@OneToMany(mappedBy = "job")
	private List<Job> jobs = new LinkedList<Job>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "DUE_DATE")
	private String dueDate;

	@Column(name = "M_S_SALE")
	private String mSSale;

	@Column(name = "STATUS")
	private boolean status;
	
	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue
	private int customerId;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT")
	private boolean updatedAt;

	@Column(name = "PO_ID")
	private int poId;

	public Job() {
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "Job [jobs=" + jobs + ", customer=" + customer + ", id=" + id + ", description=" + description
				+ ", dueDate=" + dueDate + ", mSSale=" + mSSale + ", status=" + status + ", customerId=" + customerId
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", poId=" + poId + "]";
	}

}
