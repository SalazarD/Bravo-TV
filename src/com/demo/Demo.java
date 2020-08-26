package com.demo;

import java.math.BigDecimal;
import java.util.List;
import java.sql.Timestamp;

import com.bean.Retailer;
import com.dao.RetailerDao;

public class Demo {

	public static void main(String[] args) {
		RetailerDao dao = new RetailerDao();
		Retailer retailer = new Retailer();
		retailer.setRetailerID(0);
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
		System.out.println("---");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List<Retailer> retailers = dao.getAll();
		for(Retailer r : retailers) {
			r.setRetailer_creation_date(time);
			dao.update(r);
			System.out.println(r);
		}
	}

}
