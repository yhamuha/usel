package com.usel.app.model;

public class Purchase {
	private int user_id;
	private int job_id;
	private int po;
	private int vendor_id;
	private String final_po_number;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getJob_id() {
		return job_id;
	}
	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	public int getPo() {
		return po;
	}
	public void setPo(int po) {
		this.po = po;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public String getFinal_po_number() {
		return final_po_number;
	}
	public void setFinal_po_number(String final_po_number) {
		this.final_po_number = final_po_number;
	}
}
