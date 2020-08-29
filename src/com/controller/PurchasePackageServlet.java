package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ChannelPackage;
import com.dao.PurchasePackageDao;

/**
 * Servlet implementation class RetailerWriteServlet
 */
//@WebServlet("/Retailer/Add")
public class PurchasePackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchasePackageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getParameter("RetailerName"));

		ChannelPackage chnlPackage = new ChannelPackage();
		chnlPackage.setPackage_name(request.getParameter("packageName"));
		chnlPackage.setPackage_category(request.getParameter("packageCategory"));
		chnlPackage.setPackage_charging_type(request.getParameter("packageType"));
		chnlPackage.setPackage_transmission_type(request.getParameter("packageTrans"));
		chnlPackage.setPackage_cost(new BigDecimal(request.getParameter("packageCost")));

		boolean addedByDefault;
		if (request.getParameter("addedByDefault").equalsIgnoreCase("Yes")) {
			addedByDefault = true;
		} else {
			addedByDefault = false;
		}
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		chnlPackage.setAdded_by_default(addedByDefault);
		chnlPackage.setPackage_available_from_date(Timestamp.valueOf(LocalDateTime.now().format(myFormatObj)));
		chnlPackage.setPackage_available_to_date(Timestamp.valueOf(LocalDateTime.now().format(myFormatObj)));

		PurchasePackageDao packageDao = new PurchasePackageDao();
		if (packageDao.create(chnlPackage)) {
			System.out.println("Successfully purchased the package");
			//customer id added manually for now (testing purposes)
			int customer_id = 1;
			
			if(packageDao.addPackagePurchase(customer_id, chnlPackage.getPackage_id())) {
				System.out.println("Successfully mapped package to customer");
			} else {
				System.out.println("Unsuccessful at mapping package to customer");
			}
			HttpSession session = request.getSession();
			session.setAttribute("message", "Package purchased.");
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			System.out.println("Purchase Unsuccessful");
		}
	}

}
