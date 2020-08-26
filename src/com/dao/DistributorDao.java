package com.dao;

import com.bean.Distributor;

public class DistributorDao extends AbstractDao<Distributor> {

	@Override
	protected String getTableName() {
		return "CASE_Distributor";
	}

	@Override
	protected Distributor getNewBean() {
		return new Distributor();
	}

}
