package com.dao;

import com.bean.Stb;

public class StbDao extends AbstractDao<Stb> {

	@Override
	protected String getTableName() {
		return "CASE_STB_Inventory";
	}

	@Override
	protected Stb getNewBean() {
		return new Stb();
	}

}
