package com.usel.app.model;

public class Job {
	private int id;
	private String description;
	private int customer_id;
	private int vessel_id;
	private String customer_po;
	private String due_date;
	private String m_s_sale;
	private boolean status;
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
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getVessel_id() {
		return vessel_id;
	}
	public void setVessel_id(int vessel_id) {
		this.vessel_id = vessel_id;
	}
	public String getCustomer_po() {
		return customer_po;
	}
	public void setCustomer_po(String customer_po) {
		this.customer_po = customer_po;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getM_s_sale() {
		return m_s_sale;
	}
	public void setM_s_sale(String m_s_sale) {
		this.m_s_sale = m_s_sale;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
