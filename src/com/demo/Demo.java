package com.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

//import org.json.JSONObject;

import java.sql.Timestamp;

import com.bean.Customer;
import com.bean.Retailer;
import com.dao.CustomerDao;
import com.dao.OperatorDao;
import com.dao.RetailerDao;

public class Demo {

	public static void main(String[] args) throws Exception {
		RetailerDao dao = new RetailerDao();
		/*Retailer retailer = new Retailer();
		retailer.setRetailer_id(0);
		retailer.setRetailer_name("My Retailer");
		retailer.setContact_num1("1234567");
		retailer.setContact_num2("9875");
		retailer.setAddress_1("Drive Way");
		retailer.setAddress_2("Road Ave.");
		retailer.setCity("Metropolis");
		retailer.setState_province("NY");
		retailer.setCredit_limit(BigDecimal.valueOf(100.00));
		retailer.setService_charges(BigDecimal.valueOf(3.40));
		retailer.setRetailer_creation_date(new Timestamp(System.currentTimeMillis()));
		retailer.setPassword("password");
		if (dao.create(retailer)) {
			System.out.println(retailer);
		}
		else {
			System.out.println("No bean could be made.");
		}
		System.out.println("---");*/
//		Timestamp time = new Timestamp(System.currentTimeMillis());
//		List<Retailer> retailers = dao.getAll();
//		
//		for(Retailer r : retailers) {
//			r.setRetailer_creation_date(time);
//			dao.update(r);
//			System.out.println(r);
//		}
//		
//		
//		RetailerDao rd = new RetailerDao();
//		JSONObject jb1 = new JSONObject();
//		
//		jb1.put("Data", rd.totalRetail_byState());
//		System.out.println(jb1);
//	    try {
//	    	FileWriter file = new FileWriter("WebContent/retailer_ByState.json");
//	        file.write(jb1.toString());
//	        file.close();
//	        System.out.println("JSON obj file created......");
//	      } catch (IOException e) {
//	        
//      }
//	    
//		JSONObject jb2 = new JSONObject();
//		jb2.put("Data", rd.totalRetailer_WithinYear());
//		System.out.println(jb1);
//	    try {
//	    	FileWriter file = new FileWriter("WebContent/retailer_ByMonth.json");
//	        file.write(jb2.toString());
//	        file.close();
//	        System.out.println("JSON file obj2 created......");
//	      } catch (IOException e) {
//	        
//      }
		
		
		
		
		
		
	}

}