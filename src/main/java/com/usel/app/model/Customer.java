package com.usel.app.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
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

	@OneToMany(mappedBy = "customer")
	private List<Customer> customers = new LinkedList<Customer>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VESSEL_ID")
	private Vessel vessel;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@Basic (optional = false)
	@Column(name = "CUSTOMER_PO", length = 50)
	private int ownPo;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT")
	private boolean updatedAt;

	@Column(name = "VESSEL_ID")
	private int vesselId;

	public Customer() {
	}
	
	public Customer(int id, String name, int customerPo, boolean createdAt, boolean updatedAt, int vesselId, int customerId) {
		this.id = id;
		this.name=name;
		this.ownPo=customerPo;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		this.vesselId=vesselId;
	}

	public List<Customer> getJobs() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setOwnPo(int ownPo) {
		this.ownPo = ownPo;
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

	@Override
	public String toString() {
		return "Customer [customers=" + customers + ", vessel=" + vessel + ", id=" + id + ", name=" + name + ", customerPo="
				+ ownPo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", vesselId=" + vesselId + "]";
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
        Customer e = (Customer) o;
        return (this.getId() == e.getId());
    }
}
