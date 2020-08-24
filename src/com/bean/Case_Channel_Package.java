package com.bean;

import java.math.BigDecimal;

public class Case_Channel_Package {
	private int package_id;
	private String package_name;
	private String package_charging_type;
	private String package_transmission_type;
	private BigDecimal package_cost;
	private String package_available_from_date;
	private String package_available_to_date;
	private String added_by_default;
	private String added_channel;
	public Case_Channel_Package(int package_id, String package_name, String package_charging_type,
			String package_transmission_type, BigDecimal package_cost, String package_available_from_date,
			String package_available_to_date, String added_by_default, String added_channel) {
		super();
		this.package_id = package_id;
		this.package_name = package_name;
		this.package_charging_type = package_charging_type;
		this.package_transmission_type = package_transmission_type;
		this.package_cost = package_cost;
		this.package_available_from_date = package_available_from_date;
		this.package_available_to_date = package_available_to_date;
		this.added_by_default = added_by_default;
		this.added_channel = added_channel;
	}
	public int getPackage_id() {
		return package_id;
	}
	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public String getPackage_charging_type() {
		return package_charging_type;
	}
	public void setPackage_charging_type(String package_charging_type) {
		this.package_charging_type = package_charging_type;
	}
	public String getPackage_transmission_type() {
		return package_transmission_type;
	}
	public void setPackage_transmission_type(String package_transmission_type) {
		this.package_transmission_type = package_transmission_type;
	}
	public BigDecimal getPackage_cost() {
		return package_cost;
	}
	public void setPackage_cost(BigDecimal package_cost) {
		this.package_cost = package_cost;
	}
	public String getPackage_available_from_date() {
		return package_available_from_date;
	}
	public void setPackage_available_from_date(String package_available_from_date) {
		this.package_available_from_date = package_available_from_date;
	}
	public String getPackage_available_to_date() {
		return package_available_to_date;
	}
	public void setPackage_available_to_date(String package_available_to_date) {
		this.package_available_to_date = package_available_to_date;
	}
	public String getAdded_by_default() {
		return added_by_default;
	}
	public void setAdded_by_default(String added_by_default) {
		this.added_by_default = added_by_default;
	}
	public String getAdded_channel() {
		return added_channel;
	}
	public void setAdded_channel(String added_channel) {
		this.added_channel = added_channel;
	}
	
}
