package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ChannelPackage;
import com.dao.ChannelPackageDao;
import com.dao.CustomerDao;
import com.dao.PurchasePackageDao;

/**
 * Servlet implementation class RetailerWriteServlet
 */
public class PurchasePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchasePackageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customer_id = 0;
		String userType = (String) request.getSession().getAttribute("user_type");
		
		// Get the customer ID
		if (userType == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else if (userType.equals("customer")) {
			customer_id = new CustomerDao().getCustomer((String)request.getSession().getAttribute("user_name")).getCustomer_id();
		}
		else { // we are operator or admin
			customer_id = (Integer) request.getAttribute("customer_id");
		}
		
		// Get all default packages
		ChannelPackageDao packageDao = new ChannelPackageDao();
		ArrayList<ChannelPackage> defaultPackages = packageDao.getAllDefaultPackages();
		
		// Make a map of all packages to whether the customer has purchased them (removing default packages)
		PurchasePackageDao purchaseDao = new PurchasePackageDao();
		HashMap<ChannelPackage, Boolean> purchaseMap = new HashMap<>();
		for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
			if (!cp.isAdded_by_default()) {
				purchaseMap.put(cp, true);
			}
		}
		for (ChannelPackage cp : purchaseDao.getNonPurchasedPackages(customer_id)) {
			if (!cp.isAdded_by_default()) {
				purchaseMap.put(cp, false);
			}
		}

		HttpSession session = request.getSession();
		session.setAttribute("defaultPackages", defaultPackages);
		session.setAttribute("purchaseMap", purchaseMap);
		
		request.getRequestDispatcher("/additionalPackages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customer_id = 0;
		String userType = (String) request.getSession().getAttribute("user_type");
		
		// Get the customer ID
		if (userType == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else if (userType.equals("customer")) {
			customer_id = new CustomerDao().getCustomer((String)request.getSession().getAttribute("user_name")).getCustomer_id();
		}
		else { // we are operator or admin
			customer_id = (Integer) request.getAttribute("customer_id");
		}
		
		// We need to access our Daos and generate a list of packages to purchase
		ChannelPackageDao packageDao = new ChannelPackageDao();
		PurchasePackageDao purchaseDao = new PurchasePackageDao();
		HashSet<Integer> packageIdsToPurchase = new HashSet<>();
		
		// Parse all package ids first
		int[] packageIds = parseIntArray(request.getParameterValues("packageIds"));
		
		// Filter requested packages by what the user can purchase
		HashSet<Integer> availablePackageIds = new HashSet<>();
		availablePackageIds.addAll(purchaseDao.getAvailablePackageIds(customer_id));
		for (int package_id : packageIds) {
			if (availablePackageIds.contains(package_id)) {
				packageIdsToPurchase.add(package_id);
			}
		}
		
		// Add remaining packages (operators can choose which defaults to ignore)
		for (ChannelPackage cp : packageDao.getAllDefaultPackages()) {
			packageIdsToPurchase.add(cp.getPackage_id());
		}
		
		// Clear purchases and regenerate them
		purchaseDao.removeAllPurchases(customer_id);
		for (int package_id : packageIdsToPurchase) {
			purchaseDao.addPackagePurchase(customer_id, package_id);
		}
		
		doGet(request, response);
	}
	
	private static int[] parseIntArray(String[] intStringArray) {
		if (intStringArray == null) {
			intStringArray = new String[0];
		}
		int[] results = new int[intStringArray.length];
		for (int i = 0; i < intStringArray.length; i++) {
			results[i] = Integer.valueOf(intStringArray[i]);
		}
		return results;
	}
}
