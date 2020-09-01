package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Operator;
import com.dao.LoginDao;
import com.dao.OperatorDao;

/**
 * Servlet implementation class ReadOperatorServlet
 */
//@WebServlet("/ReadOperatorServlet")
public class ReadOperatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadOperatorServlet() {
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
		if (idString != null) {
			Integer id = Integer.parseInt(idString);
			OperatorDao od = new OperatorDao();
			Operator s = od.findById(id);
			HttpSession session = request.getSession();
			session.setAttribute("operator", s);
			request.getRequestDispatcher("/editOperator.jsp").forward(request, response);

		} else if (deleteId != null) {
			OperatorDao od = new OperatorDao();
			LoginDao logindao= new LoginDao();
			logindao.deleteUser(deleteId);
			od.deleteUserWithEmail(deleteId);
			response.sendRedirect("./List");
		}
		else {
			OperatorDao od = new OperatorDao();
			ArrayList<Operator> operators = od.findAllO();
			HttpSession session = request.getSession();
			session.setAttribute("operators", operators);
			request.getRequestDispatcher("/operatorList.jsp").forward(request, response);
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
