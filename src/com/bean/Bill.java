package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Bill implements Bean {
	
	private int bill_id;
	private String customer_name;
	private String stb_type;
	private BigDecimal other_charges;
	private BigDecimal tax;
	private BigDecimal total_amount;
	private Timestamp generation_date;
	private Timestamp due_date;
	
	public int getBill_id() {
		return bill_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public String getStb_type() {
		return stb_type;
	}
	public BigDecimal getOther_charges() {
		return other_charges;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public BigDecimal getTotal_amount() {
		return total_amount;
	}
	public Timestamp getGeneration_date() {
		return generation_date;
	}
	public Timestamp getDue_date() {
		return due_date;
	}
	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setStb_type(String stb_type) {
		this.stb_type = stb_type;
	}
	public void setOther_charges(BigDecimal other_charges) {
		this.other_charges = other_charges;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}
	public void setGeneration_date(Timestamp generation_date) {
		this.generation_date = generation_date;
	}
	public void setDue_date(Timestamp due_date) {
		this.due_date = due_date;
	}
	private static final String[] COLUMN_NAMES = new String[] {
			"bill_id", "customer_name", "stb_type", "other_charges", "tax",
			"total_amount", "generation_date", "due_date"
	};
	
	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}
	@Override
	public Object[] getColumnValues() {
		return new Object[] {
				bill_id, customer_name, stb_type, other_charges, tax,
				total_amount, generation_date, due_date
		};
	}
	@Override
	public void setColumnValues(Object[] values) {
		bill_id = (int) values[0];
		customer_name = (String) values[1];
		stb_type = (String) values[2];
		other_charges = (BigDecimal) values[3];
		tax = (BigDecimal) values[4];
		total_amount = (BigDecimal) values[5];
		generation_date = (Timestamp) values[6];
		due_date = (Timestamp) values[7];
	}
}
