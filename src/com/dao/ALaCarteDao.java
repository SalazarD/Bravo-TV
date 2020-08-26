package com.dao;

import com.bean.ALaCarte;

public class ALaCarteDao extends AbstractDao<ALaCarte> {

	@Override
	protected String getTableName() {
		return "CASE_A_La_Carte";
	}

	@Override
	protected ALaCarte getNewBean() {
		return new ALaCarte();
	}

}
