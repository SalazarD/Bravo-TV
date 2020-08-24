package com.bean;

public class Case_Operator {
	private int operator_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String shift_start;
	private String shift_end;
	private int max_customers;
	private String creation_date;
	private int total_active_customers;
	private String password;
	private Boolean first_time_user;
	private Boolean admin;
	public Case_Operator(int operator_id, String first_name, String last_name, String email, String phone,
			String shift_start, String shift_end, int max_customers, String creation_date, int total_active_customers,
			String password, Boolean first_time_user, Boolean admin) {
		super();
		this.operator_id = operator_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone = phone;
		this.shift_start = shift_start;
		this.shift_end = shift_end;
		this.max_customers = max_customers;
		this.creation_date = creation_date;
		this.total_active_customers = total_active_customers;
		this.password = password;
		this.first_time_user = first_time_user;
		this.admin = admin;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getShift_start() {
		return shift_start;
	}
	public void setShift_start(String shift_start) {
		this.shift_start = shift_start;
	}
	public String getShift_end() {
		return shift_end;
	}
	public void setShift_end(String shift_end) {
		this.shift_end = shift_end;
	}
	public int getMax_customers() {
		return max_customers;
	}
	public void setMax_customers(int max_customers) {
		this.max_customers = max_customers;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public int getTotal_active_customers() {
		return total_active_customers;
	}
	public void setTotal_active_customers(int total_active_customers) {
		this.total_active_customers = total_active_customers;
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
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
}
