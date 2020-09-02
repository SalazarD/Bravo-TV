package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Channel;
import com.utilities.DbCon;

public class ChannelDao extends AbstractDao<Channel> {

	@Override
	protected String getTableName() {
		return "CASE_Channel";
	}

	@Override
	protected Channel getNewBean() {
		return new Channel();
	}
	
	public Channel findById(int channelId) {

		Connection con = DbCon.getConnection();
		Channel c = null;
		try
		{
			String qry = "SELECT * FROM "+"case_channel"+ " "+
					"WHERE channel_id = ?";

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1,channelId);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				c = new Channel();
				c.setChannel_name(rs.getString("channel_name"));
				c.setChannel_band(rs.getString("channel_band"));
				c.setVideo_carrier_frequency(rs.getInt("video_carrier_frequency"));
				c.setAudio_carrier_frequency(rs.getInt("audio_carrier_frequency"));
				c.setChannel_charge_type(rs.getString("channel_charge_type"));
				c.setChannel_transmission(rs.getString("channel_transmission"));
				c.setChannel_charge(rs.getBigDecimal("channel_charge"));
				
				c.setChannel_id(channelId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return c;
	}
	
	
	
	

}
