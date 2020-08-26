package com.dao;

import com.bean.StbType;

public class StbTypeDao extends AbstractDao<StbType> {

	@Override
	protected String getTableName() {
		return "CASE_STB_Type";
	}

	@Override
	protected StbType getNewBean() {
		return new StbType();
	}

}
