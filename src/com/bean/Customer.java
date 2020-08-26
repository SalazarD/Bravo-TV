package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Customer implements Bean {

	private int customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String address_1;
	private String address_2;
	private String land_mark;
	private int zip_code;
	private String city;
	private String state_province;
	private Timestamp customer_creation_date;
	private String password;
	private boolean first_time_user;
	private boolean pre_paid;
	private BigDecimal balance;
	private Integer assigned_operator_id;
	private Integer assigned_retailer_id;
	
	public int getCustomer_id() {
		return customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress_1() {
		return address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public String getLand_mark() {
		return land_mark;
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
	public Timestamp getCustomer_creation_date() {
		return customer_creation_date;
	}
	public String getPassword() {
		return password;
	}
	public boolean isFirst_time_user() {
		return first_time_user;
	}
	public boolean isPre_paid() {
		return pre_paid;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public Integer getAssigned_operator_id() {
		return assigned_operator_id;
	}
	public Integer getAssigned_retailer_id() {
		return assigned_retailer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public void setLand_mark(String land_mark) {
		this.land_mark = land_mark;
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
	public void setCustomer_creation_date(Timestamp customer_creation_date) {
		this.customer_creation_date = customer_creation_date;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFirst_time_user(boolean first_time_user) {
		this.first_time_user = first_time_user;
	}
	public void setPre_paid(boolean pre_paid) {
		this.pre_paid = pre_paid;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public void setAssigned_operator_id(Integer assigned_operator_id) {
		this.assigned_operator_id = assigned_operator_id;
	}
	public void setAssigned_retailer_id(Integer assigned_retailer_id) {
		this.assigned_retailer_id = assigned_retailer_id;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id
				+ ", first_name=" + first_name
				+ ", last_name=" + last_name
				+ ", email=" + email
				+ ", phone=" + phone
				+ ", address_1=" + address_1
				+ ", address_2=" + address_2
				+ ", land_mark=" + land_mark
				+ ", zip_code=" + zip_code
				+ ", city=" + city
				+ ", state_province=" + state_province
				+ ", customer_creation_date=" + customer_creation_date
				+ ", password=" + password
				+ ", first_time_user=" + first_time_user
				+ ", pre_paid=" + pre_paid
				+ ", balance=" + balance
				+ ", assigned_operator_id=" + assigned_operator_id
				+ ", assigned_retailer_id=" + assigned_retailer_id + "]";
	}

	@Override
	public String getUniqueIDName() {
		return "customer_id";
	}
}
