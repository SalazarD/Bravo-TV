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
//	private String inventory_list;				// Removed from table
	private String retailer_creation_date;
	private BigDecimal total_cost_of_inventory;
//	private String oncreate_retailer;			// Removed from table
//	private String total_reatiler_in_city;		// Removed from table
	private String password;
	private Boolean first_time_user;
	private String distributor;					// Newly added to table
	
	// Constructor with everything
	public Case_Retailer(int retailer_id, String retailer_name, String contact_num1, String contact_num2,
			String address_1, String address_2, String zip_code, String city, String state_province,
			String set_top_box_limit, BigDecimal credit_limit, BigDecimal commission_rate, BigDecimal service_charges,
			String retailer_creation_date, BigDecimal total_cost_of_inventory, String password, Boolean first_time_user,
			String distributor) {
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
		this.retailer_creation_date = retailer_creation_date;
		this.total_cost_of_inventory = total_cost_of_inventory;
		this.password = password;
		this.first_time_user = first_time_user;
		this.distributor = distributor;
	}
	
	// Constructor without Retailer ID
	public Case_Retailer(String retailer_name, String contact_num1, String contact_num2, String address_1,
			String address_2, String zip_code, String city, String state_province, String set_top_box_limit,
			BigDecimal credit_limit, BigDecimal commission_rate, BigDecimal service_charges,
			String retailer_creation_date, BigDecimal total_cost_of_inventory, String password, Boolean first_time_user,
			String distributor) {
		super();
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
		this.retailer_creation_date = retailer_creation_date;
		this.total_cost_of_inventory = total_cost_of_inventory;
		this.password = password;
		this.first_time_user = first_time_user;
		this.distributor = distributor;
	}

	// Empty Constructor
	public Case_Retailer() {
		super();
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
	public String getDistributor() {
		return distributor;
	}

	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getRetailer_id() + " " + this.getRetailer_name()+ " " + this.getContact_num1() + " " + 
				this.getContact_num2() + " " + this.getAddress_1() + " " + this.getAddress_2() + " " + 
				this.getZip_code() + " " + this.getCity() + " " + this.getState_province() + " " +
				this.getSet_top_box_limit() + " " + this.getCredit_limit() + " " + this.getCommission_rate() + " " + 
				this.getService_charges() + " " + this.getRetailer_creation_date() + " " + 
				this.getFirst_time_user() + " " + this.getDistributor();
	}
	
}
