package com.bean;

public class Stb implements Bean{
	private int std_id;
	private int stb_type_id;
	private String serial_num;
	private String mac_id;
	private String remote_asset_id;
	private String dish_asset_id;
	private String status;
	private Integer assigned_retailer_id;
	private Integer assigned_customer_id;
	
	public int getStd_id() {
		return std_id;
	}
	public int getStb_type_id() {
		return stb_type_id;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public String getMac_id() {
		return mac_id;
	}
	public String getRemote_asset_id() {
		return remote_asset_id;
	}
	public String getDish_asset_id() {
		return dish_asset_id;
	}
	public String getStatus() {
		return status;
	}
	public Integer getAssigned_retailer_id() {
		return assigned_retailer_id;
	}
	public Integer getAssigned_customer_id() {
		return assigned_customer_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public void setStb_type_id(int stb_type_id) {
		this.stb_type_id = stb_type_id;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public void setMac_id(String mac_id) {
		this.mac_id = mac_id;
	}
	public void setRemote_asset_id(String remote_asset_id) {
		this.remote_asset_id = remote_asset_id;
	}
	public void setDish_asset_id(String dish_asset_id) {
		this.dish_asset_id = dish_asset_id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setAssigned_retailer_id(Integer assigned_retailer_id) {
		this.assigned_retailer_id = assigned_retailer_id;
	}
	public void setAssigned_customer_id(Integer assigned_customer_id) {
		this.assigned_customer_id = assigned_customer_id;
	}
	
	@Override
	public String toString() {
		return "Stb [std_id=" + std_id 
				+ ", stb_type_id=" + stb_type_id 
				+ ", serial_num=" + serial_num 
				+ ", mac_id=" + mac_id 
				+ ", remote_asset_id=" + remote_asset_id 
				+ ", dish_asset_id=" + dish_asset_id 
				+ ", status=" + status 
				+ ", assigned_retailer_id=" + assigned_retailer_id 
				+ ", assigned_customer_id=" + assigned_customer_id + "]";
	}
	
	private static final String[] COLUMN_NAMES = new String[] {
			"stb_id", "stb_type_id", "serial_num", "mac_id", "remote_asset_id", "dish_asset_id",
			"status", "assigned_retailer_id", "assigned_customer_id"
	};

	@Override
	public String[] getColumnNames() {
		return COLUMN_NAMES;
	}
	@Override
	public Object[] getColumnValues() {
		return new Object[] { std_id, stb_type_id, serial_num, mac_id, remote_asset_id,
				dish_asset_id, status, assigned_retailer_id, assigned_customer_id
				
		};
	}
	@Override
	public void setColumnValues(Object[] values) {
		std_id = (int) values[0];
		stb_type_id = (int) values[1];
		serial_num = (String) values[2];
		mac_id = (String) values[3];
		remote_asset_id = (String) values[4];
		dish_asset_id = (String) values[5];
		status = (String) values[6];
		assigned_retailer_id = (Integer) values[7];
		assigned_customer_id = (Integer) values[8];
		
	}
	
	
}
