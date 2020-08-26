package com.dao;

import com.bean.Retailer;

public class RetailerDao extends AbstractDao<Retailer> {

	@Override
	protected String getTableName() {
		return "CASE_Retailer";
	}

	@Override
	protected Retailer getNewBean() {
		return new Retailer();
	}

}