package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bean.Retailer;
import com.utilities.DbCon;
//import org.json.JSONArray;
//import org.json.JSONObject;

public class RetailerDao extends AbstractDao<Retailer> {

	@Override
	protected String getTableName() {
		return "CASE_Retailer";
	}

	@Override
	protected Retailer getNewBean() {
		return new Retailer();
	}
	
//	public JSONArray totalRetail_byState() throws Exception {
//
//		JSONArray array = new JSONArray();
//		
//        try {
//
//            Connection con = DbCon.getConnection();
//            
//            String sql = "SELECT state_province, count(*) FROM  CASE_Retailer GROUP BY state_province";
//            
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//            	JSONObject record = new JSONObject();
//                record.put("state_province", rs.getString("state_province"));
//                record.put("count", rs.getString("count(*)"));
//                array.put(record);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            DbCon.closeConnection();
//        }
//
//        return array;
//    }
//	
//	
//	public JSONArray totalRetailer_WithinYear() {
//		
//		JSONArray array = new JSONArray();
//		try {
//			Connection conn = DbCon.getConnection();
//			Statement st = conn.createStatement();
//			ResultSet rSet = st.executeQuery("select monthname(retailer_creation_date) as month, count(*) FROM CASE_Retailer group by month");
//			while (rSet.next()) {
//				JSONObject record = new JSONObject();
//				record.put("month", rSet.getString("month"));
//				record.put("count", rSet.getString("count(*)"));
//				array.put(record);
//				
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			
//		}
//		finally {
//
//			DbCon.closeConnection();
//		}
//
//		return array;
//	}

}