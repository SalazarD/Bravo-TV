package com.controller;

import java.io.IOException;

import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Operator;
import com.dao.*;

public class writeOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public writeOperatorServlet() {
		super();
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
		// read values and create student object
		Operator s = new Operator();
		s.setFirst_name(request.getParameter("first_name"));
		s.setLast_name(request.getParameter("last_name"));
		s.setEmail(request.getParameter("email"));
		s.setPhone(request.getParameter("phone"));
		s.setShift_start(Timestamp.valueOf(request.getParameter("start_shift")));
		s.setMax_customers(Integer.parseInt(request.getParameter("max_customers")));
		s.setOperator_creation_date(Timestamp.valueOf(request.getParameter("operator_creation_date")));

		String action = request.getParameter("action");

		OperatorDao ssvc = new OperatorDao();

		if (action.equals("register")) {
			System.out.println("Register ");
			ssvc.create(s);

			HttpSession session = request.getSession();
			session.setAttribute("message", "Operator Registered.");
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} 
		else {
			System.out.println("Unsuccessful! Could not register");
		}
	}

}