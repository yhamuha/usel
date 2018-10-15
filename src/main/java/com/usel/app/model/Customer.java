package com.usel.app.model;

import javax.persistence.Basic;
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
@Table(name = "CUSTOMERS")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Customer {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VESSEL_ID")
	private Vessel vessel;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Basic (optional = false)
	@Column(name = "CUSTOMER_PO", length = 50)
	private int ownPo;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
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
		return "Customer [" + ", vessel=" + vessel + ", id=" + id + ", name=" + name + ", customerPo="
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
