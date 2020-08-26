package com.dao;

import com.bean.Operator;

public class OperatorDao extends AbstractDao<Operator> {

	@Override
	protected String getTableName() {
		return "CASE_Operator";
	}

	@Override
	protected Operator getNewBean() {
		return new Operator();
	}
}
