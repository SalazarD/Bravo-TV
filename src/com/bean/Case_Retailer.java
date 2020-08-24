package com.bean;

import java.math.BigDecimal;

public class Case_Retailer {
	private int retailer_id;
	private String retailer_name;
	private String contact_num1;
	private String contact_num2;
	private String address_1;
	private String address_2;
	private String zip_code;
	private String city;
	private String state_province;
	private String set_top_box_limit;
	private BigDecimal credit_limit;
	private BigDecimal commission_rate;
	private BigDecimal service_charges;
	private String inventory_list;
	private String retailer_creation_date;
	private BigDecimal total_cost_of_inventory;
	private String oncreate_retailer;
	private String total_reatiler_in_city;
	private String password;
	private Boolean first_time_user;
	public Case_Retailer(int retailer_id, String retailer_name, String contact_num1, String contact_num2,
			String address_1, String address_2, String zip_code, String city, String state_province,
			String set_top_box_limit, BigDecimal credit_limit, BigDecimal commission_rate, BigDecimal service_charges,
			String inventory_list, String retailer_creation_date, BigDecimal total_cost_of_inventory,
			String oncreate_retailer, String total_reatiler_in_city, String password, Boolean first_time_user) {
		super();
		this.retailer_id = retailer_id;
		this.retailer_name = retailer_name;
		this.contact_num1 = contact_num1;
		this.contact_num2 = contact_num2;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.zip_code = zip_code;
		this.city = city;
		this.state_province = state_province;
		this.set_top_box_limit = set_top_box_limit;
		this.credit_limit = credit_limit;
		this.commission_rate = commission_rate;
		this.service_charges = service_charges;
		this.inventory_list = inventory_list;
		this.retailer_creation_date = retailer_creation_date;
		this.total_cost_of_inventory = total_cost_of_inventory;
		this.oncreate_retailer = oncreate_retailer;
		this.total_reatiler_in_city = total_reatiler_in_city;
		this.password = password;
		this.first_time_user = first_time_user;
	}
	public int getRetailer_id() {
		return retailer_id;
	}
	public void setRetailer_id(int retailer_id) {
		this.retailer_id = retailer_id;
	}
	public String getRetailer_name() {
		return retailer_name;
	}
	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}
	public String getContact_num1() {
		return contact_num1;
	}
	public void setContact_num1(String contact_num1) {
		this.contact_num1 = contact_num1;
	}
	public String getContact_num2() {
		return contact_num2;
	}
	public void setContact_num2(String contact_num2) {
		this.contact_num2 = contact_num2;
	}
	public String getAddress_1() {
		return address_1;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState_province() {
		return state_province;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public String getSet_top_box_limit() {
		return set_top_box_limit;
	}
	public void setSet_top_box_limit(String set_top_box_limit) {
		this.set_top_box_limit = set_top_box_limit;
	}
	public BigDecimal getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}
	public BigDecimal getCommission_rate() {
		return commission_rate;
	}
	public void setCommission_rate(BigDecimal commission_rate) {
		this.commission_rate = commission_rate;
	}
	public BigDecimal getService_charges() {
		return service_charges;
	}
	public void setService_charges(BigDecimal service_charges) {
		this.service_charges = service_charges;
	}
	public String getInventory_list() {
		return inventory_list;
	}
	public void setInventory_list(String inventory_list) {
		this.inventory_list = inventory_list;
	}
	public String getRetailer_creation_date() {
		return retailer_creation_date;
	}
	public void setRetailer_creation_date(String retailer_creation_date) {
		this.retailer_creation_date = retailer_creation_date;
	}
	public BigDecimal getTotal_cost_of_inventory() {
		return total_cost_of_inventory;
	}
	public void setTotal_cost_of_inventory(BigDecimal total_cost_of_inventory) {
		this.total_cost_of_inventory = total_cost_of_inventory;
	}
	public String getOncreate_retailer() {
		return oncreate_retailer;
	}
	public void setOncreate_retailer(String oncreate_retailer) {
		this.oncreate_retailer = oncreate_retailer;
	}
	public String getTotal_reatiler_in_city() {
		return total_reatiler_in_city;
	}
	public void setTotal_reatiler_in_city(String total_reatiler_in_city) {
		this.total_reatiler_in_city = total_reatiler_in_city;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getFirst_time_user() {
		return first_time_user;
	}
	public void setFirst_time_user(Boolean first_time_user) {
		this.first_time_user = first_time_user;
	}
	
}
