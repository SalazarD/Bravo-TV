package com.dao;

import com.bean.Customer;

public class CustomerDAO extends AbstractDao<Customer> {

	@Override
	protected String getTableName() {
		return "CASE_Customer";
	}

	@Override
	protected Customer getNewBean() {
		return new Customer();
	}

}
