package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Bill;
import com.bean.Channel;
import com.bean.ChannelPackage;
import com.bean.Customer;
import com.dao.BillDao;
import com.dao.ChannelPackageDao;
import com.dao.CustomerDao;
import com.dao.PackageMapDao;
import com.dao.PurchaseMapDao;

/**
 * Servlet implementation class GenerateBillServlet
 */
//@WebServlet("/GenerateBillServlet")
public class GenerateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GenerateBillServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String idString = request.getParameter("id");

		// Init the Daos
		ChannelPackageDao packageDao = new ChannelPackageDao();
		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		PackageMapDao packageMapDao = new PackageMapDao();

		// Map packages to their channels, and to whether they are already purchased
		HashMap<Integer, ArrayList<Channel>> packageMap = new HashMap<>();
		HashMap<ChannelPackage, Boolean> purchaseMap = new HashMap<>();

		if (idString != null) {
			Integer id = Integer.parseInt(idString);
			BillDao bd = new BillDao();
			Bill b = bd.findByIdB(id);
			
			String customer_name = bd.getBill(id).getCustomer_name();
			//String customer_name = "damn@gmail.com";
			System.out.println("Customer Name: " + customer_name);
			
			CustomerDao cd = new CustomerDao();
			int customer_id = cd.getCustomer(customer_name).getCustomer_id();
			System.out.println("Customer ID: " + customer_id);

			// Make the map (keeping default packages)
			for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
				packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
				purchaseMap.put(cp, true);
			}
			for (ChannelPackage cp : purchaseDao.getNonPurchasedPackages(customer_id)) {
				packageMap.put(cp.getPackage_id(), packageMapDao.getAllChannels(cp.getPackage_id()));
				purchaseMap.put(cp, false);
			}

			HttpSession session = request.getSession();
			session.setAttribute("bill", b);
			session.setAttribute("customer_id", customer_id);
			session.setAttribute("purchaseMap", purchaseMap);
			session.setAttribute("packageMap", packageMap);
			request.getRequestDispatcher("/AO_PackageChargingView.jsp").forward(request, response);
		} else {
			BillDao bd = new BillDao();
			ArrayList<Bill> bills = bd.findAllB();
			HttpSession session = request.getSession();
			session.setAttribute("bills", bills);
			System.out.print(session.getAttribute("user_type"));
			request.getRequestDispatcher("/AO_PackageCharging.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Bill bills = new Bill();
		BillDao bd = new BillDao();
		CustomerDao cd = new CustomerDao();
		//int sizeC = cd.findNoC() + 1;
		//System.out.println("Test: " + sizeC);

		bd.deleteExistingData();
		
		for(int i = 1; i <= 20; i++)
		{
			bd.generateForCustomer(i, bills);
			bd.create(bills);		
		}
		
		doGet(request, response);

		//System.out.println("Test: " + bills.toString());

	}

}
