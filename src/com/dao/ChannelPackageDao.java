package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bean.Channel;
import com.bean.ChannelPackage;
import com.utilities.DbCon;

public class ChannelPackageDao extends AbstractDao<ChannelPackage> {

	@Override
	protected String getTableName() {
		return "CASE_Channel_Package";
	}

	@Override
	protected ChannelPackage getNewBean() {
		return new ChannelPackage();
	}
	public Set<String> allCategory(){
		Set<String> allCategory = new HashSet<String>();
		String sql=" select package_category from CASE_Channel_Package";
		Connection connect=DbCon.getConnection();
		ResultSet resultset=null;
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			resultset=stmt.executeQuery();
			while(resultset.next()) {
				allCategory.add(resultset.getNString("package_category"));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
		return allCategory;
	}
	public List<Channel> getAllChannel(){
		ChannelDao channeldao = new ChannelDao();
		List<Channel> allChannel= channeldao.getAll();
		return allChannel;
	}
	
	public void mappingChannelwithPack(int package_id,  ArrayList<Integer> channel_id) {
		String sql="insert into CASE_Package_Map (package_id,channel_id) values "
				+ "(?,?)";
		
		int resultset;
		for(int channelID: channel_id) {
			Connection connect=DbCon.getConnection();	
			try
			{
				PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
				stmt.setInt(1, package_id);
				stmt.setInt(2,channelID);
				resultset=stmt.executeUpdate();
			}catch(Exception e){
				System.out.println(e);
			}
			finally
			{
				DbCon.closeConnection();
			}
		}

		
	}

}
