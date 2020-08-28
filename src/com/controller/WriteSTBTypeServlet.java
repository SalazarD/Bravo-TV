package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.StbType;
import com.dao.StbTypeDao;

/**
 * Servlet implementation class WriteSTBTypeServlet
 */
//@WebServlet("/WriteSTBTypeServlet")
public class WriteSTBTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteSTBTypeServlet() {
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

		StbType stbType = new StbType();
		stbType.setType(request.getParameter("type"));

		String featuresDemo = "";
		String feature[] = request.getParameterValues("features");

		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < feature.length; i++)
		{
			sb.append(feature[i] + ", ");
		}
		
		featuresDemo = sb.toString();
		stbType.setFeatures(featuresDemo);
		
		stbType.setLength(new BigDecimal(request.getParameter("length")));
		stbType.setBreadth(new BigDecimal(request.getParameter("breadth")));
		stbType.setWidth(new BigDecimal(request.getParameter("width")));
		stbType.setPrice(new BigDecimal(request.getParameter("price")));
		stbType.setInstall_charges(new BigDecimal(request.getParameter("install_charge")));
		stbType.setUpgrade_charge(new BigDecimal(request.getParameter("upgrade_charge")));
		stbType.setDiscount(Integer.parseInt(request.getParameter("discount")));
		stbType.setBilling_type(request.getParameter("billing_type"));
		stbType.setRefundable_deposit(new BigDecimal(request.getParameter("refundable_deposit")));


		StbTypeDao stbTypeDao = new StbTypeDao();

		if (stbTypeDao.create(stbType)) {
			System.out.println("Successfully created STB Type");
			HttpSession session = request.getSession();
			session.setAttribute("message", "STB Type created.");
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			System.out.println("Unable to create STB Type");
		}
	}

}
