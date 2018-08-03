package com.usel.app.model;

public class Customer {
	private int id;
	private String name;
	private int vessel_id;
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
	public int getVessel_id() {
		return vessel_id;
	}
	public void setVessel_id(int vessel_id) {
		this.vessel_id = vessel_id;
	}
}
