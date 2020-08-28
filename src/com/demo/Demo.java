package com.demo;

import java.math.BigDecimal;
import java.util.List;
import java.sql.Timestamp;

import com.bean.ChannelPackage;
import com.bean.Customer;
import com.bean.Retailer;
import com.dao.ChannelPackageDao;
import com.dao.CustomerDao;
import com.dao.OperatorDao;
import com.dao.PurchasePackageDao;
import com.dao.RetailerDao;

public class Demo {

	public static void main(String[] args) {
		Customer c = new CustomerDao().getAll().get(0);
		ChannelPackage p = new ChannelPackageDao().getAll().get(0);
		
		PurchasePackageDao purchaser = new PurchasePackageDao();
		purchaser.addPackagePurchase(c.getCustomer_id(), p.getPackage_id());
		
		for (ChannelPackage bought : purchaser.getPurchasedPackages(c.getCustomer_id())) {
			System.out.println(bought);
			purchaser.removePackagePurchase(c.getCustomer_id(),  p.getPackage_id());
		}
	}

}
