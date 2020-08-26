package com.bean;

import java.math.BigDecimal;

public class StbType implements Bean{
	
	private int stb_type_id;
	private String type;
	private BigDecimal length;
	private BigDecimal breadth;
	private BigDecimal width;
	private BigDecimal price;
	private BigDecimal install_charges;
	private BigDecimal upgrade_charge;
	private int discount;
	private String billing_type;
	private BigDecimal refundable_deposit;
	
	public int getStb_type_id() {
		return stb_type_id;
	}
	public void setStb_type_id(int stb_type_id) {
		this.stb_type_id = stb_type_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getBreadth() {
		return breadth;
	}
	public void setBreadth(BigDecimal breadth) {
		this.breadth = breadth;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getInstall_charges() {
		return install_charges;
	}
	public void setInstall_charges(BigDecimal install_charges) {
		this.install_charges = install_charges;
	}
	public BigDecimal getUpgrade_charge() {
		return upgrade_charge;
	}
	public void setUpgrade_charge(BigDecimal upgrade_charge) {
		this.upgrade_charge = upgrade_charge;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getBilling_type() {
		return billing_type;
	}
	public void setBilling_type(String billing_type) {
		this.billing_type = billing_type;
	}
	public BigDecimal getRefundable_deposit() {
		return refundable_deposit;
	}
	public void setRefundable_deposit(BigDecimal refundable_deposit) {
		this.refundable_deposit = refundable_deposit;
	}
	@Override
	public String toString() {
		return "StbType [stb_type_id=" + stb_type_id 
				+ ", type=" + type 
				+ ", length=" + length 
				+ ", breadth=" + breadth
				+ ", width=" + width 
				+ ", price=" + price 
				+ ", install_charges=" + install_charges 
				+ ", upgrade_charge=" + upgrade_charge 
				+ ", discount=" + discount 
				+ ", billing_type=" + billing_type 
				+ ", refundable_deposit=" + refundable_deposit + "]";
	}
	
	@Override
	public String getUniqueIDName() {
		return "stb_type_id";
	}
}
