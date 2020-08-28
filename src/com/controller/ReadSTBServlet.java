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
		
		StbTypeDao dao = new StbTypeDao();
		StbType stb = new StbType();
		
		stb.setStb_type_id(1);
		if (dao.read(stb)) {
			System.out.println(stb);
			
			HttpSession session = request.getSession();
			session.setAttribute("stbType", stb);
		} else {
			System.out.println("Unsuccessful read for stbType");
		}
		
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
