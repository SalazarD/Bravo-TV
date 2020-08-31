package com.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Stb;
import com.dao.StbDao;

//@WebServlet("/ReadPurchaseServlet")
public class ReadPurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadPurchaseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Stb stb = new Stb();
		StbDao sd = new StbDao();
		String idStbType = request.getParameter("id");
		int id = Integer.parseInt(idStbType);

		//		stb.setStd_id(1);
		stb = sd.findAllSTB(id);
		System.out.println(stb);

		HttpSession session = request.getSession();
		session.setAttribute("stb", stb);
		request.getRequestDispatcher("/C_PurchaseBoxTotal.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stb stb = new Stb();
		String email = request.getParameter("email");
		stb.setStd_id(Integer.parseInt(request.getParameter("std_id")));
		stb.setStb_type_id(Integer.parseInt(request.getParameter("stb_type_id")));
		stb.setSerial_num(request.getParameter("serial_num"));
		stb.setMac_id(request.getParameter("mac_id"));
		stb.setRemote_asset_id(request.getParameter("remote_asset_id"));
		stb.setDish_asset_id(request.getParameter("dish_asset_id"));
		stb.setStatus("Assigned");
		stb.setAssigned_retailer_id(Integer.parseInt(request.getParameter("assigned_retailer_id")));
		stb.setPayable(new BigDecimal(request.getParameter("payable")));
		
		StbDao sd = new StbDao();
		
		sd.purchaseStb(stb, email);
		System.out.println("Customer purchased set top box.");
		HttpSession session = request.getSession();
		session.setAttribute("message", "Box purchased!");
		request.getRequestDispatcher("homepage.jsp").forward(request, response);
	}

}