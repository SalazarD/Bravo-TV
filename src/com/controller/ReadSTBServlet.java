package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.StbType;
import com.dao.StbTypeDao;

/**
 * Servlet implementation class ReadSTBServlet
 */
//@WebServlet("/ReadSTBServlet")
public class ReadSTBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadSTBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached the get function of the ReadSTBServlet");
		StbTypeDao dao = new StbTypeDao();
		StbType stb = new StbType();
		String billing_type = request.getParameter("billingType");
		System.out.println("billing type: "+billing_type);
		String box_type = request.getParameter("topBoxType");
		System.out.println("bow type: "+box_type);
		//stb.setStb_type_id(1);
		stb = dao.getByTwoTypes(box_type, billing_type);
		//System.out.println("Retrieved the box using two types");
		//System.out.println(stb.toString());
		HttpSession session = request.getSession();
		session.setAttribute("stbType", stb);
		request.getRequestDispatcher("/C_PurchaseBox.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
