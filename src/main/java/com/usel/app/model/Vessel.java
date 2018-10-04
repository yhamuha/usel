package com.usel.app.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VESSELS")
public class Vessel {

	@OneToMany(mappedBy = "vessel")
	private List<Vessel> vessel = new LinkedList<Vessel>();

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CREATED_AT")
	private boolean createdAt;

	@Column(name = "UPDATED_AT")
	private boolean updatedAt;

	@Column(name = "CUSTOMER_ID")
	private int customerId;

	public Vessel() {
	}
	
	public Vessel(int id, String name, boolean createdAt, boolean updatedAt, int customerId) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.customerId = customerId;
	}

	public List<Vessel> getVessel() {
		return vessel;
	}

	public void setVessel(List<Vessel> vessel) {
		this.vessel = vessel;
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Vessel [vessel=" + vessel + ", id=" + id + ", name=" + name + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", customerId=" + customerId + "]";
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
        Vessel e = (Vessel) o;
        return (this.getId() == e.getId());
    }
	
}
