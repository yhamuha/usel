package com.usel.app.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	@ManyToOne
	@JoinColumn (name="customer_id", nullable = false, insertable=false, updatable=false)
	private Purchase purchase;
	
	@OneToMany(mappedBy = "customer") 
	private Set<Job> jobs;
	
	@OneToMany(mappedBy = "customer") 
	private Set<Vessel> vessels;
	
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

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	@Column (name = "customer_id", nullable = false)
	private int customerId;

	public Customer() {
	}
	
	public Customer(int id, String name, int customerPo, Date createdAt, Date updatedAt) {
		this.id = id;
		this.name=name;
		this.ownPo=customerPo;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
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
	
	public void setVessel(Set<Vessel> vessels) {
		this.vessels = vessels;
	}
	
	public void setJob(Set<Job> jobs) {
		this.jobs = jobs;
	}
	
	@Override
	public String toString() {
		return "Customer [vessel=" + vessels + ", job=" + jobs + ", id=" + id + ", name="
				+ name + ", ownPo=" + ownPo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
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
