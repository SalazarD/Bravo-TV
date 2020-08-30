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
import com.bean.PurchaseChannelPackage;
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
	public ArrayList<ChannelPackage> defaultPackage(boolean addedbydefault){
		ArrayList<ChannelPackage> packagesList=new ArrayList<ChannelPackage>();
		String sql="select * from CASE_Channel_Package where added_by_default=?";
		Connection connect=DbCon.getConnection();
		ResultSet resultset=null;
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setBoolean(1,addedbydefault);
			resultset=stmt.executeQuery();
			while(resultset.next()) {
				ChannelPackage channelpackage=new ChannelPackage();
				channelpackage.setPackage_id(resultset.getInt("package_id"));
				channelpackage.setPackage_name(resultset.getNString("package_name"));
				channelpackage.setPackage_category(resultset.getNString("package_category"));
				channelpackage.setPackage_charging_type(resultset.getNString("package_charging_type"));
				channelpackage.setPackage_transmission_type(resultset.getNString("package_transmission_type"));
				channelpackage.setPackage_cost(resultset.getBigDecimal("package_cost"));
				channelpackage.setPackage_available_from_date(resultset.getTimestamp("package_available_from_date"));
				channelpackage.setPackage_available_to_date(resultset.getTimestamp("package_available_to_date"));
				channelpackage.setAdded_by_default(resultset.getBoolean("added_by_default"));
				packagesList.add(channelpackage);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
		return packagesList;
	}

	public Set<String> allNotAddedByDefaultCategory(){
		Set<String> allCategory = new HashSet<String>();
		String sql=" select package_category from CASE_Channel_Package where added_by_default=false";
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
	public boolean packageNameExist(String packageName) {

		String sql=" select * from case_channel_package where package_name=?";
		Connection connect=DbCon.getConnection();
		ResultSet resultset=null;
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			stmt.setString(1, packageName);
			resultset=stmt.executeQuery();
			while(resultset.next()) {
				return true;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}
		return false;
	}
	public ArrayList<PurchaseChannelPackage> getMappedPackage() {
		
		ArrayList<PurchaseChannelPackage> packagemapping=new ArrayList<PurchaseChannelPackage>();
		String sql="select case_channel_package.package_name,case_channel_package.package_cost,case_channel.channel_name,case_channel.channel_charge\r\n" + 
				"from case_channel_package, CASE_Package_Map, case_channel\r\n" + 
				"where CASE_Package_Map.package_id =case_channel_package.package_id  and CASE_Package_Map.channel_id = case_channel.channel_id and case_channel_package.added_by_default=false;\r\n" + 
				"";
		Connection connect=DbCon.getConnection();
		ResultSet resultset=null;
		try
		{
			PreparedStatement stmt=connect.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 				
			resultset=stmt.executeQuery();
			while(resultset.next()) {
				PurchaseChannelPackage packageobj= new PurchaseChannelPackage();
				packageobj.setPackage_name(resultset.getNString("package_name"));
				packageobj.setChannel_name(resultset.getNString("channel_name"));
				packageobj.setPackage_cost(resultset.getBigDecimal("package_cost"));
				packageobj.setChannel_charge(resultset.getBigDecimal("channel_charge"));
				packagemapping.add(packageobj);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		finally
		{
			DbCon.closeConnection();
		}		
		return packagemapping;
	}
	
}
