package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import com.demo.Demo;

/**
 * Servlet implementation class DisplayReportsServlet
 */
public class DisplayReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayReportsServlet() {
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
		String jsonString = null;
		Demo demo = new Demo();
		String path = null;
		int chart = Integer.parseInt(request.getParameter("chart"));
		if(chart == 1) {
			
		} else if(chart == 2) {
			
		} else if(chart == 3) {
			
		} else if(chart == 4) {
			
		} else if(chart == 5) {
			try {
				jsonString = demo.retailerByState();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(chart == 6) {
			try {
				jsonString = demo.retailerByMonth();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HttpSession session = request.getSession();
		//session.setAttribute("toDisplay", chart);
		request.setAttribute("toDisplay", chart);
		request.setAttribute("jsonString", jsonString);
		//session.setAttribute("jsonString", jsonString);
		request.getRequestDispatcher("/displayreports.jsp").forward(request, response);
		
		//doGet(request, response);
	}

}
