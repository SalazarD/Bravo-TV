package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.LoginDao;

/**
 * Servlet implementation class WriteCustomerServlet
 */
//@WebServlet("/WriteCustomerServlet")
public class WriteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		Customer customer = new Customer();

		//get the parameters
		customer.setFirst_name(request.getParameter("firstname"));
		customer.setLast_name(request.getParameter("lastname"));
		customer.setEmail(request.getParameter("email")); //make sure to set this in the auth table
		customer.setPhone(request.getParameter("phone"));
		customer.setAddress_1(request.getParameter("address_1"));
		customer.setAddress_2(request.getParameter("address_2"));
		customer.setLand_mark(request.getParameter("landmark"));
		customer.setZip_code(Integer.parseInt(request.getParameter("zip")));
		customer.setCity(request.getParameter("city"));
		customer.setState_province(request.getParameter("state"));
		customer.setPre_paid(Boolean.parseBoolean(request.getParameter("prePaid")));
		customer.setBalance(new BigDecimal(request.getParameter("balance")));
		customer.setAssigned_operator_id(Integer.parseInt(request.getParameter("O_name")));
		customer.setAssigned_retailer_id(Integer.parseInt(request.getParameter("R_name")));

		String action = request.getParameter("action");

		CustomerDao customerService = new CustomerDao();
		LoginDao authTable = new LoginDao();
		
		if (action.equals("add")) {
			customer.setCustomer_creation_date(new Timestamp(System.currentTimeMillis()));
			customerService.create(customer);
			authTable.insertUser(customer.getEmail(), "defaultpassword", "customer", true);
			System.out.println("Added!");

			HttpSession session = request.getSession();
			session.setAttribute("message", "Customer added!");
			request.getRequestDispatcher("List").forward(request, response);
		}
		else if (action.equals("update")) {
			customer.setCustomer_id(Integer.parseInt(request.getParameter("customerId")));
			//System.out.println("Date: " + customer.getCustomer_creation_date());
			customer.setCustomer_creation_date(Timestamp.valueOf(request.getParameter("date")));
			System.out.println("Update " + customer);
			customerService.update(customer);

			HttpSession session = request.getSession();
			session.setAttribute("message", "Customer updated.");
			request.getRequestDispatcher("List").forward(request, response);

		}

	}

}
