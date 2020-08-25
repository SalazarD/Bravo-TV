package com.demo;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.bean.Case_Customer;
import com.bean.Case_Retailer;
import com.dao.OperatorDao;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Case_Customer customer= new Case_Customer(1,"Charlie2","Walsh2","1048676295@qq.com","123456789","Address Demo 1","N/A","N/A",91040,"LA","CA","2019-12-31 23:59:59","operator 1","retailer_1","password_1",true);
		Case_Retailer retailer= new Case_Retailer(1, "Update 2.0", "123123123", "123123123", "address 1", "Address Demo 2",
				"91040", "LA", "CA", "100", BigDecimal.valueOf(59999.00), BigDecimal.valueOf(0.20), BigDecimal.valueOf(100.00), 
				"a list of inventory", "2019-12-31 23:59:59", BigDecimal.valueOf(100000000.00), "on create", "100", "password 1", true);

		OperatorDao dao= new OperatorDao();
//		dao.insertRetailer(retailer);
//		dao.updateCustomer(customer);
//		dao.insertCustomer(customer);
		dao.deleteRetailer(retailer);
//		printList(dao.getAllRetailer());
		
	}
	public static void printList(ArrayList<Case_Retailer> customers) {
		for(Case_Retailer customer: customers) {
			System.out.println(customer.toString());
		}
	}

}
