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
@Table(name = "jobs")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)

public class Job {
	
	@ManyToOne
	@JoinColumn (name="job_id", nullable = false, insertable=false, updatable=false)
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
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.DATE)
    @LastModifiedDate
	private Date updatedAt;
	
	@Column (name = "job_id", nullable = false)
	private int jobId;

	public Job() {
	}

	public Job(int id, String description, Date dueDate, String mSSale, boolean status/*, int customerId*/, Date createdAt, Date updatedAt/*, int poId*/) {
		this.id=id;
		this.description=description;
		this.dueDate=dueDate;
		this.mSSale=mSSale;
		this.status=status;
		this.createdAt=createdAt;
		this.updatedAt=updatedAt;
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
		return "Job [id=" + id + ", description=" + description + ", dueDate=" + dueDate
				+ ", mSSale=" + mSSale + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
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
        Job e = (Job) o;
        return (this.getId() == e.getId());
    }
	
}
