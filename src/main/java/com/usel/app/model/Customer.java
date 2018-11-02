package com.usel.app.model;

import java.util.Date;
import javax.persistence.Basic;
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
@Table (name = "customers")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Customer{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vessel_id", insertable=false, updatable=false)
	private Vessel vessel;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Basic (optional = false)
	@Column(name = "own_po", length = 50)
	private int ownPo;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updatedAt", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;

	/*@Column(name = "vessel_id", nullable = false)
	private int vesselId;*/
	
	public Customer() {
	}
	
	public Customer(int id, String name, int customerPo, Date createdAt, Date updatedAt/*, int vesselId*/, int customerId) {
		this.id = id;
		this.name=name;
		this.ownPo=customerPo;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		//this.vesselId=vesselId;
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
	
	/*public int getVesselId() {
		return vesselId;
	}
	
	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}*/

	@Override
	public String toString() {
		return "Customer [vessel=" + vessel + ", id=" + id + ", name=" + name + ", ownPo=" + ownPo + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt /*+ ", vesselId=" + vesselId*/ + "]";
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
