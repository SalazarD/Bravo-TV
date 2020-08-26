package com.dao;

import com.bean.Channel;

public class ChannelDao extends AbstractDao<Channel> {

	@Override
	protected String getTableName() {
		return "CASE_Channel";
	}

	@Override
	protected Channel getNewBean() {
		return new Channel();
	}

}
