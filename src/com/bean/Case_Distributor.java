package com.bean;

import java.math.BigDecimal;

public class Case_Distributor {
	private int distributor_id;
	private String distributor_id_name;
	private String contact_num1;
	private String contact_num2;
	private String address_1;
	private String address_2;
	private String zip_code;
	private String city;
	private String zone;
	private String set_top_box_limit;
	private BigDecimal credit_limit;
	private String retailer_list;
	private String inventory_list;
	private BigDecimal total_cost_of_inventory;
	public Case_Distributor(int distributor_id, String distributor_id_name, String contact_num1, String contact_num2,
			String address_1, String address_2, String zip_code, String city, String zone, String set_top_box_limit,
			BigDecimal credit_limit, String retailer_list, String inventory_list, BigDecimal total_cost_of_inventory) {
		super();
		this.distributor_id = distributor_id;
		this.distributor_id_name = distributor_id_name;
		this.contact_num1 = contact_num1;
		this.contact_num2 = contact_num2;
		this.address_1 = address_1;
		this.address_2 = address_2;
		this.zip_code = zip_code;
		this.city = city;
		this.zone = zone;
		this.set_top_box_limit = set_top_box_limit;
		this.credit_limit = credit_limit;
		this.retailer_list = retailer_list;
		this.inventory_list = inventory_list;
		this.total_cost_of_inventory = total_cost_of_inventory;
	}
	public int getDistributor_id() {
		return distributor_id;
	}
	public void setDistributor_id(int distributor_id) {
		this.distributor_id = distributor_id;
	}
	public String getDistributor_id_name() {
		return distributor_id_name;
	}
	public void setDistributor_id_name(String distributor_id_name) {
		this.distributor_id_name = distributor_id_name;
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
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
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
	public String getRetailer_list() {
		return retailer_list;
	}
	public void setRetailer_list(String retailer_list) {
		this.retailer_list = retailer_list;
	}
	public String getInventory_list() {
		return inventory_list;
	}
	public void setInventory_list(String inventory_list) {
		this.inventory_list = inventory_list;
	}
	public BigDecimal getTotal_cost_of_inventory() {
		return total_cost_of_inventory;
	}
	public void setTotal_cost_of_inventory(BigDecimal total_cost_of_inventory) {
		this.total_cost_of_inventory = total_cost_of_inventory;
	}
	
}
