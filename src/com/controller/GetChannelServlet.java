package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Channel;
import com.dao.ChannelDao;

/**
 * Servlet implementation class GetChannelServlet
 */
//@WebServlet("/GetChannelServlet")
public class GetChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetChannelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*response.getWriter().append("Served at: get channel here").append(request.getContextPath());
		response.getWriter().println("hello from getStudent");
		System.out.println("channel added!");*/
		
		
		ChannelDao channelDao = new ChannelDao();

        
        
        /*System.out.println("hereee");
		PrintWriter out=response.getWriter();
		
		for (Channel e: channels) {
			
			out.print("["+e.getChannel_name()+"]");

		}*/
        
        String idString = request.getParameter("id");
        if (idString != null) {
        	Integer id = Integer.parseInt(idString);
        	Channel channel = channelDao.findById(id);
        	
        	HttpSession session = request.getSession();
			session.setAttribute("channel", channel);
			request.getRequestDispatcher("/editChannel.jsp").forward(request, response);
        }
        
        else {
        	List<Channel> channels = channelDao.getAll();
        	  
        	HttpSession session = request.getSession();
            session.setAttribute("channels", channels);
            request.getRequestDispatcher("./channelList.jsp").forward(request, response);
        	
        }

        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
