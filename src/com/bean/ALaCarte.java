package com.bean;

import java.math.BigDecimal;

public class ALaCarte implements Bean{
	private int customer_id;
	private BigDecimal total_cost;
	private BigDecimal selection_charges;
	private int discount;
	private int tax;
	private BigDecimal amount_payable;
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public BigDecimal getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(BigDecimal total_cost) {
		this.total_cost = total_cost;
	}
	public BigDecimal getSelection_charges() {
		return selection_charges;
	}
	public void setSelection_charges(BigDecimal selection_charges) {
		this.selection_charges = selection_charges;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public BigDecimal getAmount_payable() {
		return amount_payable;
	}
	public void setAmount_payable(BigDecimal amount_payable) {
		this.amount_payable = amount_payable;
	}
	
	
	@Override
	public String toString() {
		return "ALaCarte [customer_id=" + customer_id 
				+ ", total_cost=" + total_cost 
				+ ", selection_charges=" + selection_charges 
				+ ", discount=" + discount 
				+ ", tax=" + tax 
				+ ", amount_payable=" + amount_payable+ "]";
	}
	
	private static final String[] COLUMN_NAMES = new String[] {"customer_id", "total_cost", "selection_charges",
					"discount", "tax", "amount_payable"};
	
	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}
	@Override
	public Object[] getColumnValues() {
		return new Object[] {
				customer_id, total_cost, selection_charges, discount, tax, amount_payable 
		};
	}
	@Override
	public void setColumnValues(Object[] values) {
		customer_id = (int) values[0];
		total_cost = (BigDecimal) values[1];
		selection_charges = (BigDecimal) values[2];
		discount = (int) values[3];
		tax = (int) values[4];
		amount_payable = (BigDecimal) values[5];	
	}
}
