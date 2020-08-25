package com.bean;

public class Case_Customer {
	private int customer_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private String phone_number;
	private String address_one;
	private String address_two;
	private String land_mark;
	private int zip_code;
	private String city;
	private String state;
	private String customer_creation_date;
	private String assigned_operator;
	private String assigned_retailer;
	private int purchased_stb;
	private int purchased_package;
	private int purchased_channel;
	private String password;
	private Boolean first_time_user;
	public Case_Customer(int customer_id, String first_name, String last_name, String email_id, String phone_number,
			String address_one, String address_two, String land_mark, int zip_code, String city, String state,
			String customer_creation_date, String assigned_operator, String assigned_retailer, String password, Boolean first_time_user) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone_number = phone_number;
		this.address_one = address_one;
		this.address_two = address_two;
		this.land_mark = land_mark;
		this.zip_code = zip_code;
		this.city = city;
		this.state = state;
		this.customer_creation_date = customer_creation_date;
		this.assigned_operator = assigned_operator;
		this.assigned_retailer = assigned_retailer;
		this.password = password;
		this.first_time_user = first_time_user;
	}
	
	public Case_Customer() {
		super();
	}

	public Case_Customer(String first_name, String last_name, String email_id, String phone_number, String address_one,
			String address_two, String land_mark, int zip_code, String city, String state,
			String customer_creation_date, String assigned_operator, String assigned_retailer, String password, Boolean first_time_user) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.phone_number = phone_number;
		this.address_one = address_one;
		this.address_two = address_two;
		this.land_mark = land_mark;
		this.zip_code = zip_code;
		this.city = city;
		this.state = state;
		this.customer_creation_date = customer_creation_date;
		this.assigned_operator = assigned_operator;
		this.assigned_retailer = assigned_retailer;
		this.purchased_stb = purchased_stb;
		this.purchased_package = purchased_package;
		this.purchased_channel = purchased_channel;
		this.password = password;
		this.first_time_user = first_time_user;
	}

	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress_one() {
		return address_one;
	}
	public void setAddress_one(String address_one) {
		this.address_one = address_one;
	}
	public String getAddress_two() {
		return address_two;
	}
	public void setAddress_two(String address_two) {
		this.address_two = address_two;
	}
	public String getLand_mark() {
		return land_mark;
	}
	public void setLand_mark(String land_mark) {
		this.land_mark = land_mark;
	}
	public int getZip_code() {
		return zip_code;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCustomer_creation_date() {
		return customer_creation_date;
	}
	public void setCustomer_creation_date(String customer_creation_date) {
		this.customer_creation_date = customer_creation_date;
	}
	public String getAssigned_operator() {
		return assigned_operator;
	}
	public void setAssigned_operator(String assigned_operator) {
		this.assigned_operator = assigned_operator;
	}
	public String getAssigned_retailer() {
		return assigned_retailer;
	}
	public void setAssigned_retailer(String assigned_retailer) {
		this.assigned_retailer = assigned_retailer;
	}
	public int getPurchased_stb() {
		return purchased_stb;
	}
	public void setPurchased_stb(int purchased_stb) {
		this.purchased_stb = purchased_stb;
	}
	public int getPurchased_package() {
		return purchased_package;
	}
	public void setPurchased_package(int purchased_package) {
		this.purchased_package = purchased_package;
	}
	public int getPurchased_channel() {
		return purchased_channel;
	}
	public void setPurchased_channel(int purchased_channel) {
		this.purchased_channel = purchased_channel;
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

	@Override
	public String toString() {
		return "Case_Customer [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email_id=" + email_id + ", phone_number=" + phone_number + ", address_one=" + address_one
				+ ", address_two=" + address_two + ", land_mark=" + land_mark + ", zip_code=" + zip_code + ", city="
				+ city + ", state=" + state + ", customer_creation_date=" + customer_creation_date
				+ ", assigned_operator=" + assigned_operator + ", assigned_retailer=" + assigned_retailer
				+ ", password=" + password + ", first_time_user=" + first_time_user + "]";
	}
	
}
