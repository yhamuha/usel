package com.usel.app.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "customers")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)

public class Customer{

	/*@OneToMany(mappedBy = "purchases")
	private Set<Purchase> purchases;
	
	@OneToMany(mappedBy = "job")
	private Set<Job> job;
	
	@OneToMany(mappedBy = "vessels")
	private Set<Vessel> vessels;*/
	
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
	
	// private Set<Job> job;
	
	// private Set<Vessel> vessel;
	
	public Customer() {
	}
	
	public Customer(/*int id,*/ String name, int ownPo, Date createdAt, Date updatedAt/*, int vesselId*//*, int customerId*/) {
		//this.id = id;
		this.name=name;
		this.ownPo=ownPo;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
		//this.vesselId=vesselId;
	}

	public int getId() {
		return id;
	}
	
	/*public void setId(int id) {
		this.id = id;
	}*/
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getOwnPo() {
		return ownPo;
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
	
	/*public Set<Job> getJob(){
		return job;
	}
	
	public void setJob(Set<Job> job) {
		this.job = job;
	}
	
	public Set<Vessel> getVessel(){
		return vessel;
	}
	
	public void setVessel(Set<Vessel> vessel) {
		this.vessel = vessel;
	}*/
	
	/*public int getVesselId() {
		return vesselId;
	}
	
	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}*/

	@Override
	public String toString() {
		return "Customer [" /*+ "purchases=" + purchases + ", job=" + job + ", vessels=" + vessels*/ + ", id=" + id + ", name="
				+ name + ", ownPo=" + ownPo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ownPo;
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
		Customer other = (Customer) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownPo != other.ownPo)
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

}
