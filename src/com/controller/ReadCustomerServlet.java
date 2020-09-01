package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.dao.LoginDao;

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
		String deleteId = request.getParameter("deleteId");
		HttpSession session = request.getSession();

		if (idString != null) {
			Integer id = Integer.parseInt(idString);
			CustomerDao cd = new CustomerDao();
			Customer s = cd.findById(id);
			session.setAttribute("customer", s);
			request.getRequestDispatcher("/editCustomer.jsp").forward(request, response);

		} else if (deleteId != null) {
			//delete user with email because we dont have user ID in case_auth table
			System.out.println(deleteId);
			String deleteEmail = deleteId;
			CustomerDao cd = new CustomerDao();
			LoginDao logindao= new LoginDao();
			
			cd.deleteUserWithEmail(deleteEmail);
			logindao.deleteUser(deleteEmail);
			response.sendRedirect("./List");
		}
		else {
			//when create customer, check user_type. 
			if(session.getAttribute("user_type")!=null) {
					if(session.getAttribute("user_type").equals("customer")) {
						System.out.print(session.getAttribute("user_type").equals("customer"));
						CustomerDao cd = new CustomerDao();
						ArrayList<Customer> customers = new ArrayList<Customer>();
						customers.add(cd.getCustomer(session.getAttribute("user_name").toString()));
						session.setAttribute("customers", customers);
						session.setAttribute("deleteCustomer_view", "hidden");
						session.setAttribute("deleteChannel_view", "hidden");
						session.setAttribute("editChannel_view", "hidden");
						System.out.print(session.getAttribute("user_type"));
						request.getRequestDispatcher("/customerList.jsp").forward(request, response);		
					}
					else{
						CustomerDao cd = new CustomerDao();
						ArrayList<Customer> customers = cd.findAllC();
						session.setAttribute("customers", customers);
						System.out.print(session.getAttribute("user_type"));
						request.getRequestDispatcher("/customerList.jsp").forward(request, response);	
					}
			}
			else {
				 PrintWriter out = response.getWriter();
		         out.println("<script type=\"text/javascript\">");
		         out.println("alert('Registration success');");
		         out.println("location='/BravoTV/index.jsp';");
		         out.println("</script>");			
		         }
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
