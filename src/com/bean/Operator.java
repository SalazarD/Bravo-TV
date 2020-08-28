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
	
	public Operator() {
		first_name = "";
		last_name = "";
		email = "";
		phone = "";
		shift_start = new Timestamp(System.currentTimeMillis());
		operator_creation_date = new Timestamp(System.currentTimeMillis());
	}

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
				+ "]";
	}

	private static final String[] COLUMN_NAMES = new String[] { "operator_id", "first_name", "last_name", "email",
			"phone", "shift_start", "max_customers", "operator_creation_date"};

	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}

	@Override
	public Object[] getColumnValues() {
		return new Object[] { operator_id, first_name, last_name, email, phone, shift_start, max_customers,
				operator_creation_date};
	}

	@Override
	public void setColumnValues(Object[] values) {
		this.operator_id = (int) values[0];
		this.first_name = (String) values[1];
		this.last_name = (String) values[2];
		this.email = (String) values[3];
		this.phone = (String) values[4];
		this.shift_start = (Timestamp) values[5];
		this.max_customers = (int) values[6];
		this.operator_creation_date = (Timestamp) values[7];
	}
}