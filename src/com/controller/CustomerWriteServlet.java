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

/**
 * Servlet implementation class CustomerWriteServlet
 */
//@WebServlet("/Customer/Add")
public class CustomerWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer customer = new Customer();
		
		//get the parameters
		customer.setCustomer_id(Integer.parseInt(request.getParameter("customerId")));
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
		customer.setCustomer_creation_date(Timestamp.valueOf(request.getParameter("date")+" 00:00:00")); //need to set default to the day's date
		//customer.setPassword(request.getParameter("password"));  MAKE SURE TO SET THIS TO DEFAULT IN THE AUTH TABLE
		//customer.setFirst_time_user(Boolean.getBoolean(request.getParameter("firstTime"))); SET THIS IN THE AUTH TABLE
		customer.setPre_paid(Boolean.getBoolean(request.getParameter("prePaid")));
		customer.setBalance(new BigDecimal(request.getParameter("balance")));
		customer.setAssigned_operator_id(Integer.parseInt(request.getParameter("O_name")));
		customer.setAssigned_retailer_id(Integer.parseInt(request.getParameter("R_name")));
		
		
		String action = request.getParameter("action");
		
		CustomerDao customerService = new CustomerDao();
		
		//Waiting on Charles to create this function.
		//LoginDao authTable = new LoginDao();
		//System.out.println(customer.toString());
		boolean success = false;
		
		if(action.equals("add")) {
			success = customerService.create(customer);
			
			//Waiting on Charles.
			//authTable.insertUser(customer.getEmail(), "defaultpassword", "customer", true);
			//HttpSession session = request.getSession();
			//session.setAttribute("message", "Customer Added.");
			//request.getRequestDispatcher("/customerList.jsp").forward(request, response);
			request.getRequestDispatcher("/Customer/List").forward(request, response);
		} else {
			success = customerService.update(customer);
		}
		
		//doGet(request, response);
	}

}
