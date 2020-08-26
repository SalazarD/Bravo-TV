package com.dao;

import com.bean.Vod;

public class VodDao extends AbstractDao<Vod> {

	@Override
	protected String getTableName() {
		return "CASE_VOD";
	}

	@Override
	protected Vod getNewBean() {
		return new Vod();
	}

}
