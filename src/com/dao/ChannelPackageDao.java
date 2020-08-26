package com.dao;

import com.bean.ChannelPackage;

public class ChannelPackageDao extends AbstractDao<ChannelPackage> {

	@Override
	protected String getTableName() {
		return "CASE_Channel_Package";
	}

	@Override
	protected ChannelPackage getNewBean() {
		return new ChannelPackage();
	}

}
