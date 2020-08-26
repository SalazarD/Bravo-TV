package com.bean;

import java.sql.Timestamp;

public class Operator implements Bean {
	private int operator_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private Timestamp shift_start;
	private int max_customers;
	private Timestamp operator_creation_date;
	private String password;
	private Boolean first_time_user;

	public int getOperator_id() {
		return operator_id;
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

	public Timestamp getShift_start() {
		return shift_start;
	}

	public int getMax_customers() {
		return max_customers;
	}

	public Timestamp getOperator_creation_date() {
		return operator_creation_date;
	}

	public String getPassword() {
		return password;
	}

	public Boolean getFirst_time_user() {
		return first_time_user;
	}

	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
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

	public void setShift_start(Timestamp shift_start) {
		this.shift_start = shift_start;
	}

	public void setMax_customers(int max_customers) {
		this.max_customers = max_customers;
	}

	public void setOperator_creation_date(Timestamp operator_creation_date) {
		this.operator_creation_date = operator_creation_date;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirst_time_user(Boolean first_time_user) {
		this.first_time_user = first_time_user;
	}

	@Override
	public String toString() {
		return "Operator [operator_id=" + operator_id
				+ ", first_name=" + first_name
				+ ", last_name=" + last_name
				+ ", email=" + email
				+ ", phone=" + phone
				+ ", shift_start=" + shift_start
				+ ", max_customers=" + max_customers
				+ ", operator_creation_date=" + operator_creation_date
				+ ", password=" + password
				+ ", first_time_user=" + first_time_user + "]";
	}

	@Override
	public String getUniqueIDName() {
		return "operator_id";
	}
}
