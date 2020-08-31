package com.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		/*ChannelPackage p = new ChannelPackage();
		p.setPackage_name("Non-Purchased Package");
		p.setPackage_category("Some Category");
		p.setPackage_charging_type("A Charging Type");
		p.setPackage_transmission_type("Funny Transmission Type");
		p.setPackage_cost(BigDecimal.ZERO);
		p.setPackage_available_from_date(new Timestamp(System.currentTimeMillis()));
		p.setPackage_available_to_date(new Timestamp(System.currentTimeMillis()));
		p.setAdded_by_default(true);
		ChannelPackageDao dao = new ChannelPackageDao();
		dao.create(p);
		System.out.println(p);*/
		/*PurchasePackageDao dao = new PurchasePackageDao();
		dao.addPackagePurchase(2, 1);*/
		int customer_id = 2;
		
		ArrayList<ChannelPackage> defaultPackages = new ChannelPackageDao().getAllDefaultPackages();
		
		PurchasePackageDao purchaseDao = new PurchasePackageDao();
		ArrayList<ChannelPackage> purchasedPackages = purchaseDao.getPurchasedPackages(customer_id);
		ArrayList<ChannelPackage> availablePackages = purchaseDao.getNonPurchasedPackages(customer_id);
		
		System.out.println("-- Default Packages --");
		for (ChannelPackage cp : defaultPackages) System.out.println(cp);
		System.out.println("-- Purchased Packages --");
		for (ChannelPackage cp : purchasedPackages) System.out.println(cp);
		System.out.println("-- Available Packages --");
		for (ChannelPackage cp : availablePackages) System.out.println(cp);
	}

}