package com.bean;

import java.math.BigDecimal;

public class Distributor implements Bean{
	private int distributor_id;
	private String distributor_name;
	private String contact_num1;
	private String contact_num2;
	private String address_1;
	private String address_2;
	private int zip_code;
	private String city;
	private String zone;
	private int set_top_box_limit;
	private BigDecimal credit_limit;
	
	public int getDistributor_id() {
		return distributor_id;
	}
	public String getDistributor_name() {
		return distributor_name;
	}
	public String getContact_num1() {
		return contact_num1;
	}
	public String getContact_num2() {
		return contact_num2;
	}
	public String getAddress_1() {
		return address_1;
	}
	public String getAddress_2() {
		return address_2;
	}
	public int getZip_code() {
		return zip_code;
	}
	public String getCity() {
		return city;
	}
	public String getZone() {
		return zone;
	}
	public int getSet_top_box_limit() {
		return set_top_box_limit;
	}
	public BigDecimal getCredit_limit() {
		return credit_limit;
	}
	public void setDistributor_id(int distributor_id) {
		this.distributor_id = distributor_id;
	}
	public void setDistributor_name(String distributor_name) {
		this.distributor_name = distributor_name;
	}
	public void setContact_num1(String contact_num1) {
		this.contact_num1 = contact_num1;
	}
	public void setContact_num2(String contact_num2) {
		this.contact_num2 = contact_num2;
	}
	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}
	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}
	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public void setSet_top_box_limit(int set_top_box_limit) {
		this.set_top_box_limit = set_top_box_limit;
	}
	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}
	@Override
	public String toString() {
		return "Distributor [distributor_id=" + distributor_id 
				+ ", distributor_name=" + distributor_name
				+ ", contact_num1=" + contact_num1 
				+ ", contact_num2=" + contact_num2 
				+ ", address_1=" + address_1
				+ ", address_2=" + address_2 
				+ ", zip_code=" + zip_code 
				+ ", city=" + city 
				+ ", zone=" + zone
				+ ", set_top_box_limit=" + set_top_box_limit 
				+ ", credit_limit=" + credit_limit + "]";
	}
	
	private static final String[] COLUMN_NAMES = new String[] {
			"distributor_id", "distributor_name", "contact_num1", "contact_num2", "address_1",
			"address_2", "zip_code", "city", "zone", "set_top_box_limit", "credit_limit"
	};

	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}
	@Override
	public Object[] getColumnValues() {
		return new Object[] {
				distributor_id, distributor_name, contact_num1, contact_num2, address_1, address_2,
				zip_code, city, zone, set_top_box_limit, credit_limit
		};
	}
	@Override
	public void setColumnValues(Object[] values) {
		distributor_id = (int) values[0];
		distributor_name = (String) values[1];
		contact_num1 = (String) values[2];
		contact_num2 = (String) values[3];
		address_1 = (String) values[4];
		address_2 = (String) values[5];
		zip_code = (int) values[6];
		city = (String) values[7];
		zone = (String) values[8];
		set_top_box_limit = (int) values[9];
		credit_limit = (BigDecimal) values[10];
		
	}
	
	
}
