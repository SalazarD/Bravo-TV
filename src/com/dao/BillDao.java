package com.dao;

import com.bean.Bill;

public class BillDao extends AbstractDao<Bill> {

	@Override
	protected String getTableName() {
		return "CASE_Bill";
	}

	@Override
	protected Bill getNewBean() {
		return new Bill();
	}

}
