package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ChannelPackage;
import com.bean.PurchaseChannelPackage;
import com.dao.ChannelPackageDao;

/**
 * Servlet implementation class ReadPackageServlet
 */
@WebServlet("/ReadPackageServlet")
public class ReadPackageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadPackageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("ReadPackageServlet do get ");
//		HttpSession session = request.getSession();
//		ChannelPackageDao packagedao=new ChannelPackageDao();
//		ArrayList<ChannelPackage> addByDefaultList=packagedao.defaultPackage(true);
//		session.setAttribute("addByDefaultList", addByDefaultList);
//		request.getRequestDispatcher("/additionalPackages.jsp").forward(request, response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ReadPackageServlet do post ");
		HttpSession session = request.getSession();
		ChannelPackageDao packagedao=new ChannelPackageDao();
		int[]testArray = {1,2,3,4,5,5,6,7,7};
		ArrayList<ChannelPackage> addByDefaultList=packagedao.defaultPackage(true);
		ArrayList<ChannelPackage> notAddByDefaultList=packagedao.defaultPackage(false);
		ArrayList<PurchaseChannelPackage> mappedPackage=packagedao.getMappedPackage();
		
		session.setAttribute("addByDefaultList", addByDefaultList);
		session.setAttribute("notAddByDefaultList", notAddByDefaultList);
		session.setAttribute("mappedPackage", mappedPackage);

		request.getRequestDispatcher("/additionalPackages.jsp").forward(request, response);
	}

}
