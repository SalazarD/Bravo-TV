package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Customer;
import com.dao.CustomerDao;

/**
 * Servlet implementation class ReadCustomerServlet
 */
//@WebServlet("/ReadCustomerServlet")
public class ReadCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		if (idString != null) {
			Integer id = Integer.parseInt(idString);
			CustomerDao cd = new CustomerDao();
			Customer s = cd.findById(id);
			HttpSession session = request.getSession();
			session.setAttribute("customer", s);
			request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);

		}
		else {
			CustomerDao cd = new CustomerDao();
			ArrayList<Customer> customers = cd.findAllC();
			HttpSession session = request.getSession();
			session.setAttribute("customers", customers);
			System.out.print(session.getAttribute("user_type"));
			request.getRequestDispatcher("/customerList.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
