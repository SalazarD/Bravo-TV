package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.dao.ChangePasswordDao;
import com.dao.LoginDao;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		ChangePasswordDao changePwDao= new ChangePasswordDao();
		LoginDao logindao=new LoginDao();
		String user_name=request.getParameter("userName");
		String user_old_password=request.getParameter("oldPassword");
		String user_new_password=request.getParameter("changePassword");
		PrintWriter out = response.getWriter();
		
		if(logindao.validateUser(user_name, user_old_password)) {
			changePwDao.changePassword(user_name, user_new_password);
			changePwDao.changeFirstTimeUser(user_name);
			
	         out.println("<script type=\"text/javascript\">");
	         out.println("alert('Password Change Successful !!! Now Please Login Again');");
	         out.println("location='./login.jsp';");
	         out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
	        out.println("alert('No Matching Username/password !!! Now Please try Again');");
	        out.println("location='./ChangePassword.jsp';");
			out.println("</script>");
		}
		
	}

}
