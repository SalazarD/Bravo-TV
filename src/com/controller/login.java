package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name=request.getParameter("username");
		String user_password=request.getParameter("password");
		HttpSession session = request.getSession();
		LoginDao logindao= new LoginDao();
		
		if(logindao.validateUser(user_name,user_password)) {
			String user_type=logindao.checkType(user_name, user_password);
			session.setAttribute("user_name", user_name);
			session.setAttribute("user_type", user_type);
			switch(user_type) {
			  case "admin":
				  logindao.viewPremission(session, request, "show","show","show","show","show","show","show","show","show","show","show");
				  if(logindao.checkFirstTimeUser(user_name, user_password)) {
					  response.sendRedirect("./ChangePassword.jsp");
				  }else {
					  response.sendRedirect("./homepage.jsp");					  
				  }
			    break;
			  case "customer":
				  logindao.viewPremission(session, request,"show", "hidden","show","hidden","show","hidden","show","hidden","hidden","hidden","hidden");
				  session.setAttribute("display_reports_view","hidden");
				  session.setAttribute("display_charging_view","hidden");		

				  if(logindao.checkFirstTimeUser(user_name, user_password)) {
					  response.sendRedirect("./ChangePassword.jsp");
				  }else {
					  response.sendRedirect("./homepage.jsp");					  
				  }
				break;
			  case "operator":
				  logindao.viewPremission(session, request, "show","show","show","show","show","show","show","show","hidden","show","show");
				  if(logindao.checkFirstTimeUser(user_name, user_password)) {
					  response.sendRedirect("./ChangePassword.jsp");
				  }else {
					  response.sendRedirect("./homepage.jsp");					  
				  }
				break;
			  default:
				  session.setAttribute("menu_view","hidden");		
				  response.sendRedirect("./homepage.jsp");
			}
		}else {
			PrintWriter out = response.getWriter();
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Invalide Username/Password');");
	         out.println("location='./index.jsp';");
	         out.println("</script>");
			  session.setAttribute("menu_view","hidden");		
		}
	}
}