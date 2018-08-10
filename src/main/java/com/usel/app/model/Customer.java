package com.usel.app.model;

import java.util.ArrayList;
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
@Table(name = "CUSTOMERS")
public class Customer {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_ID")
	private Job job;

	@OneToMany(mappedBy = "vessel")
	private List<Vessel> items = new ArrayList<Vessel>();

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue
	private int customerId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CUSTOMER_PO")
	private int customerPo;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT")
	private boolean updatedAt;

	@Id
	@Column(name = "VESSEL_ID")
	@GeneratedValue
	private int vesselId;

	@Column(name = "JOB_ID")
	private int jobId;

	public Customer() {
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Vessel> getItems() {
		return items;
	}

	public void setItems(List<Vessel> items) {
		this.items = items;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerPo() {
		return customerPo;
	}

	public void setCustomerPo(int customerPo) {
		this.customerPo = customerPo;
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

	public int getVesselId() {
		return vesselId;
	}

	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

}
