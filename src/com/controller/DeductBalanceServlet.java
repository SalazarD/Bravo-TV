package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ChannelPackage;
import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.PurchaseMapDao;

public class DeductBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeductBalanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirect user if they are customer
		if (request.getSession().getAttribute("user_type") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else if (request.getSession().getAttribute("user_type").equals("customer")) {
			request.getRequestDispatcher("/homepage.jsp").forward(request, response);
			return;
		}
		
		// Get all prepaid customers
		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> prepaidCustomers = customerDao.getAllPrepaidCustomers();
		
		// Calculate package costs
		HashMap<Customer, BigDecimal> deductionMap = new HashMap<>();
		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		for (Customer customer : prepaidCustomers) {
			BigDecimal packageCostTotal = BigDecimal.ZERO;
			for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer.getCustomer_id())) {
				packageCostTotal = packageCostTotal.add(cp.getPackage_cost());
			}
			long numDaysInMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
			packageCostTotal = packageCostTotal.divide(new BigDecimal(numDaysInMonth), RoundingMode.FLOOR);
			deductionMap.put(customer, packageCostTotal);
		}
		
		// Forward to display page
		request.setAttribute("prepaidCustomers", prepaidCustomers);
		request.setAttribute("deductionMap", deductionMap);
		request.getRequestDispatcher("/deductBalance.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Redirect user if they are customer
		if (request.getSession().getAttribute("user_type") == null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		else if (request.getSession().getAttribute("user_type").equals("customer")) {
			request.getRequestDispatcher("/homepage.jsp").forward(request, response);
			return;
		}
		
		// Get all prepaid customers
		CustomerDao customerDao = new CustomerDao();
		ArrayList<Customer> prepaidCustomers = customerDao.getAllPrepaidCustomers();
		
		// Get all deductions/update balances
		for (Customer customer : prepaidCustomers) {
			BigDecimal deduction = new BigDecimal(request.getParameter("deduction"+customer.getCustomer_id()));
			customer.setBalance(customer.getBalance().subtract(deduction));
			customerDao.update(customer);
		}
		
		// Now redirect to page
		doGet(request, response);
	}

}
