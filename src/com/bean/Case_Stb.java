package com.bean;

import java.math.BigDecimal;

public class Case_Stb {
	private int std_id;
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
	private String serial_num;
	private String mac_id;
	private String remote_asset_id;
	private String dish_asset_id;
	private String status;
	public Case_Stb(int std_id, String type, BigDecimal length, BigDecimal breadth, BigDecimal width, BigDecimal price,
			BigDecimal install_charges, BigDecimal upgrade_charge, int discount, String billing_type,
			BigDecimal refundable_deposit, String serial_num, String mac_id, String remote_asset_id,
			String dish_asset_id, String status) {
		super();
		this.std_id = std_id;
		this.type = type;
		this.length = length;
		this.breadth = breadth;
		this.width = width;
		this.price = price;
		this.install_charges = install_charges;
		this.upgrade_charge = upgrade_charge;
		this.discount = discount;
		this.billing_type = billing_type;
		this.refundable_deposit = refundable_deposit;
		this.serial_num = serial_num;
		this.mac_id = mac_id;
		this.remote_asset_id = remote_asset_id;
		this.dish_asset_id = dish_asset_id;
		this.status = status;
	}
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
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
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public String getMac_id() {
		return mac_id;
	}
	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}
	public String getRemote_asset_id() {
		return remote_asset_id;
	}
	public void setRemote_asset_id(String remote_asset_id) {
		this.remote_asset_id = remote_asset_id;
	}
	public String getDish_asset_id() {
		return dish_asset_id;
	}
	public void setDish_asset_id(String dish_asset_id) {
		this.dish_asset_id = dish_asset_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
