package com.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Retailer;
import com.dao.RetailerDao;

/**
 * Servlet implementation class RetailerWriteServlet
 */
//@WebServlet("/Retailer/Add")
public class RetailerWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailerWriteServlet() {
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
//		System.out.println(request.getParameter("RetailerName"));
		
		Retailer retailer = new Retailer();
		retailer.setRetailer_name(request.getParameter("RetailerName"));
		retailer.setContact_num1(request.getParameter("contact1"));
		retailer.setContact_num2(request.getParameter("contact2"));
		retailer.setAddress_1(request.getParameter("address1"));
		retailer.setAddress_2(request.getParameter("address2"));
		retailer.setZip_code(Integer.parseInt(request.getParameter("zipcode")));
		retailer.setCity(request.getParameter("city"));
		retailer.setState_province(request.getParameter("state"));
		retailer.setSet_top_box_limit(Integer.parseInt(request.getParameter("topBoxLimit")));
		retailer.setCredit_limit(new BigDecimal(request.getParameter("creditLimit")));
		retailer.setCommission_rate(Integer.parseInt(request.getParameter("commissionPercent")));
		retailer.setService_charges(new BigDecimal(request.getParameter("serviceCharges")));
		
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		retailer.setRetailer_creation_date(Timestamp.valueOf(LocalDateTime.now().format(myFormatObj)));
		
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		RetailerDao retailerDao = new RetailerDao();
		if (retailerDao.create(retailer)) {
			System.out.println("Successfully created retailer");
			HttpSession session = request.getSession();
			session.setAttribute("message", "Retialer created.");
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
		} else {
			System.out.println("Usuccessful to creat retailer");
		}
	}

}
