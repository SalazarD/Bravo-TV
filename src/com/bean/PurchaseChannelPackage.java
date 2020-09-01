package com.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PurchaseChannelPackage {
	private String package_name;
	private BigDecimal package_cost;
	private String channel_name;
	private BigDecimal channel_charge;
	public PurchaseChannelPackage() {
		super();
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String package_name) {
		this.package_name = package_name;
	}
	public BigDecimal getPackage_cost() {
		return package_cost;
	}
	public void setPackage_cost(BigDecimal package_cost) {
		this.package_cost = package_cost;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public BigDecimal getChannel_charge() {
		return channel_charge;
	}
	public void setChannel_charge(BigDecimal channel_charge) {
		this.channel_charge = channel_charge;
	}
	@Override
	public String toString() {
		return "PurchaseChannelPackage [package_name=" + package_name + ", package_cost=" + package_cost
				+ ", channel_name=" + channel_name + ", channel_charge=" + channel_charge + "]";
	}
	

	
}
