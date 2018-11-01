package com.usel.app.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "vessels")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Vessel {

	@ManyToOne
	@JoinColumn (name="vessel_id", nullable = false, insertable=false, updatable=false)
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "created_at", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	@Column (name = "vessel_id", nullable = false)
	private int vesselId;

	public Vessel() {
	}
	
	public Vessel(int id, String name, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	@Override
	public String toString() {
		return "Vessel [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
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
