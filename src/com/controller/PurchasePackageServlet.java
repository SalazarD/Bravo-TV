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

import com.bean.Channel;
import com.bean.ChannelPackage;
import com.bean.Customer;
import com.dao.ChannelPackageDao;
import com.dao.CustomerDao;
import com.dao.PackageMapDao;
import com.dao.PurchaseMapDao;

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
		
		// Init the Daos
		ChannelPackageDao packageDao = new ChannelPackageDao();
		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		PackageMapDao packageMapDao = new PackageMapDao();
		
		// Map packages to their channels, and to whether they are already purchased
		HashMap<Integer, ArrayList<Channel>> packageMap = new HashMap<>();
		HashMap<ChannelPackage, Boolean> purchaseMap = new HashMap<>();
		
		// user must be logged in
		if (userType == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		
		// user is customer
		else if (userType.equals("customer")) {
			customer_id = new CustomerDao().getCustomer((String)request.getSession().getAttribute("user_name")).getCustomer_id();

			ArrayList<ChannelPackage> defaultPackages = packageDao.getAllDefaultPackages();

			// Make the map (removing default packages)
			for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
				if (!cp.isAdded_by_default()) {
					packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
					purchaseMap.put(cp, true);
				}
			}
			for (ChannelPackage cp : purchaseDao.getNonPurchasedPackages(customer_id)) {
				if (!cp.isAdded_by_default()) {
					packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
					purchaseMap.put(cp, false);
				}
			}
			for (ChannelPackage cp : defaultPackages) {
				packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
			}

			request.setAttribute("defaultPackages", defaultPackages);
			request.setAttribute("purchaseMap", purchaseMap);
			request.setAttribute("packageMap", packageMap);
			
			request.getRequestDispatcher("/additionalPackages.jsp").forward(request, response);
		}
		
		// user is operator/admin
		else if (request.getParameter("customer_id") == null) {
			request.getRequestDispatcher("/additionalPackagesOperator.jsp").forward(request, response);
		}
		else {
			Customer c = new Customer();
			boolean success;
			
			// Search must yield an actual customer
			try {
				customer_id = Integer.valueOf(request.getParameter("customer_id"));
				c.setCustomer_id(customer_id);
				success = new CustomerDao().read(c);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				success = false;
			}
			if (success) {

				// Make the map (keeping default packages)
				for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
					packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
					purchaseMap.put(cp, true);
				}
				for (ChannelPackage cp : purchaseDao.getNonPurchasedPackages(customer_id)) {
					packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
					purchaseMap.put(cp, false);
				}
				
				request.setAttribute("customer_id", customer_id);
				request.setAttribute("purchaseMap", purchaseMap);
				request.setAttribute("packageMap", packageMap);
			}
			
			request.getRequestDispatcher("/additionalPackagesOperator.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// We need to access our Daos and generate a list of packages to purchase
		ChannelPackageDao packageDao = new ChannelPackageDao();
		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		HashSet<Integer> packageIdsToPurchase = new HashSet<>();
		
		// Parse all package ids first
		int[] packageIds = parseIntArray(request.getParameterValues("packageIds"));
		
		int customer_id = 0;
		String userType = (String) request.getSession().getAttribute("user_type");
		HashSet<Integer> availablePackageIds = new HashSet<>();

		// Get the customer ID
		if (userType == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else if (userType.equals("customer")) {
			customer_id = new CustomerDao().getCustomer((String)request.getSession().getAttribute("user_name")).getCustomer_id();
			
			// Filter requested packages by what the user can purchase
			availablePackageIds.addAll(purchaseDao.getAvailablePackageIds(customer_id));
			for (int package_id : packageIds) {
				if (availablePackageIds.contains(package_id)) {
					packageIdsToPurchase.add(package_id);
				}
			}
			
			// Add remaining packages
			for (ChannelPackage cp : packageDao.getAllDefaultPackages()) {
				packageIdsToPurchase.add(cp.getPackage_id());
			}
		}
		else { // we are operator or admin
			
			 if(request.getParameter("customer_id")!=null) {
	                customer_id = Integer.valueOf(request.getParameter("customer_id"));                
	            }else {
	                customer_id=-1;
	            }
			 
			// add all requested packages... we trust operator 
			for (int package_id : packageIds) {
				packageIdsToPurchase.add(package_id);
			}
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
