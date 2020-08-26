package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Retailer implements Bean {

	private int retailer_id;
	private String retailer_name;
	private String contact_num1;
	private String contact_num2;
	private String address_1;
	private String address_2;
	private int zip_code;
	private String city;
	private String state_province;
	private int set_top_box_limit;
	private BigDecimal credit_limit;
	private int commission_rate;
	private BigDecimal service_charges;
	private Timestamp retailer_creation_date;
	private String password;
	private boolean first_time_user;
	private int assigned_distributor_id;
	
	public int getRetailer_id() {
		return retailer_id;
	}
	public String getRetailer_name() {
		return retailer_name;
	}
	public String getContact_num1() {
		return contact_num1;
	}
	public String getContact_num2() {
		return contact_num2;
	}
	public String getAddress_1() {
		return address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public int getZip_code() {
		return zip_code;
	}
	public String getCity() {
		return city;
	}
	public String getState_province() {
		return state_province;
	}
	public int getSet_top_box_limit() {
		return set_top_box_limit;
	}
	public BigDecimal getCredit_limit() {
		return credit_limit;
	}
	public int getCommission_rate() {
		return commission_rate;
	}
	public BigDecimal getService_charges() {
		return service_charges;
	}
	public Timestamp getRetailer_creation_date() {
		return retailer_creation_date;
	}
	public String getPassword() {
		return password;
	}
	public boolean isFirst_time_user() {
		return first_time_user;
	}
	public int getAssigned_distributor_id() {
		return assigned_distributor_id;
	}
	public void setRetailer_id(int retailer_id) {
		this.retailer_id = retailer_id;
	}
	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}
	public void setContact_num1(String contact_num1) {
		this.contact_num1 = contact_num1;
	}
	public void setContact_num2(String contact_num2) {
		this.contact_num2 = contact_num2;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState_province(String state_province) {
		this.state_province = state_province;
	}
	public void setSet_top_box_limit(int set_top_box_limit) {
		this.set_top_box_limit = set_top_box_limit;
	}
	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}
	public void setCommission_rate(int commission_rate) {
		this.commission_rate = commission_rate;
	}
	public void setService_charges(BigDecimal service_charges) {
		this.service_charges = service_charges;
	}
	public void setRetailer_creation_date(Timestamp retailer_creation_date) {
		this.retailer_creation_date = retailer_creation_date;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirst_time_user(boolean first_time_user) {
		this.first_time_user = first_time_user;
	}
	public void setAssigned_distributor_id(int assigned_distributor_id) {
		this.assigned_distributor_id = assigned_distributor_id;
	}

	@Override
	public String toString() {
		return "Retailer [retailer_id=" + retailer_id
				+ ", retailer_name=" + retailer_name
				+ ", contact_num1=" + contact_num1
				+ ", contact_num2=" + contact_num2
				+ ", address_1=" + address_1
				+ ", address_2=" + address_2
				+ ", zip_code=" + zip_code
				+ ", city=" + city
				+ ", state_province=" + state_province
				+ ", set_top_box_limit=" + set_top_box_limit
				+ ", credit_limit=" + credit_limit
				+ ", commission_rate=" + commission_rate
				+ ", service_charges=" + service_charges
				+ ", retailer_creation_date=" + retailer_creation_date
				+ ", password=" + password
				+ ", first_time_user=" + first_time_user
				+ ", assigned_distributor_id=" + assigned_distributor_id + "]";
	}
	
	private static final String[] COLUMN_NAMES = new String[] { "retailer_id", "retailer_name", "contact_num1",
			"contact_num2", "address_1", "address_2", "zip_code", "city", "state_province", "set_top_box_limit",
			"credit_limit", "commission_rate", "service_charges", "retailer_creation_date",
			"password", "first_time_user", "assigned_distributor_id" };

	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}

	@Override
	public Object[] getColumnValues() {
		return new Object[] { retailer_id, retailer_name, contact_num1, contact_num2, address_1, address_2, zip_code,
				city, state_province, set_top_box_limit, credit_limit, commission_rate, service_charges,
				retailer_creation_date, password, first_time_user, assigned_distributor_id };
	}

	@Override
	public void setColumnValues(Object[] values) {
		retailer_id = (int) values[0];
		retailer_name = (String) values[1];
		contact_num1 = (String) values[2];
		contact_num2 = (String) values[3];
		address_1 = (String) values[4];
		address_2 = (String) values[5];
		zip_code = (int) values[6];
		city = (String) values[7];
		state_province = (String) values[8];
		set_top_box_limit = (int) values[9];
		credit_limit = (BigDecimal) values[10];
		commission_rate = (int) values[11];
		service_charges = (BigDecimal) values[12];
		retailer_creation_date = (Timestamp) values[13];
		password = (String) values[14];
		first_time_user = (boolean) values[15];
		assigned_distributor_id = (int) values[16];
	}
}
