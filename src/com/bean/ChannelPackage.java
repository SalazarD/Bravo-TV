package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class ChannelPackage implements Bean{

	private int package_id;
	private String package_name;
	private String package_category;
	private String package_charging_type;
	private String package_transmission_type;
	private BigDecimal package_cost;
	private Timestamp package_available_from_date;
	private Timestamp package_available_to_date;
	private boolean added_by_default;
	
	public int getPackage_id() {
		return package_id;
	}
	public String getPackage_name() {
		return package_name;
	}
	public String getPackage_category() {
		return package_category;
	}
	public String getPackage_charging_type() {
		return package_charging_type;
	}
	public String getPackage_transmission_type() {
		return package_transmission_type;
	}
	public BigDecimal getPackage_cost() {
		return package_cost;
	}
	public Timestamp getPackage_available_from_date() {
		return package_available_from_date;
	}
	public Timestamp getPackage_available_to_date() {
		return package_available_to_date;
	}
	public boolean isAdded_by_default() {
		return added_by_default;
	}
	public void setPackage_id(int package_id) {
		this.package_id = package_id;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public void setPackage_category(String package_category) {
		this.package_category = package_category;
	}
	public void setPackage_charging_type(String package_charging_type) {
		this.package_charging_type = package_charging_type;
	}
	public void setPackage_transmission_type(String package_transmission_type) {
		this.package_transmission_type = package_transmission_type;
	}
	public void setPackage_cost(BigDecimal package_cost) {
		this.package_cost = package_cost;
	}
	public void setPackage_available_from_date(Timestamp package_available_from_date) {
		this.package_available_from_date = package_available_from_date;
	}
	public void setPackage_available_to_date(Timestamp package_available_to_date) {
		this.package_available_to_date = package_available_to_date;
	}
	public void setAdded_by_default(boolean added_by_default) {
		this.added_by_default = added_by_default;
	}
	
	@Override
	public String toString() {
		return "ChannelPackage [package_id=" + package_id 
				+ ", package_name=" + package_name 
				+ ", package_category=" + package_category 
				+ ", package_charging_type=" + package_charging_type 
				+ ", package_transmission_type=" + package_transmission_type 
				+ ", package_cost=" + package_cost 
				+ ", package_available_from_date=" + package_available_from_date 
				+ ", package_available_to_date=" + package_available_to_date
				+ ", added_by_default=" + added_by_default + "]";
	}
	
	@Override
	public String getUniqueIDName() {
		return "package_id";
	}
}
