package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Channel;
import com.dao.ChannelDao;

import java.util.List;

/**
 * Servlet implementation class ChannelServlet
 */
//@WebServlet("/ChannelServlet")
public class ChannelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChannelServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: channel servlet").append(request.getContextPath());
		
//		ChannelDao channelDao = new ChannelDao();
//
//        List<Channel> channels = channelDao.getAll();
//        
//        
//        System.out.println("hereee");
//		PrintWriter out=response.getWriter();
//		
//		for (Channel e: channels) {
//			
//			out.print("["+e.getChannel_name()+"]");
//
//		}
//
//        HttpSession session = request.getSession();
//        session.setAttribute("channels", channels);
//        request.getRequestDispatcher("./channelList.jsp").forward(request, response);
//        
        
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String channelname = request.getParameter("channelName");
		String channelband = request.getParameter("channelBand");
		int video = Integer.parseInt(request.getParameter("video"));
		int audio = Integer.parseInt(request.getParameter("audio"));
		String chargeType = request.getParameter("chargeType");
		Double charge = Double.parseDouble(request.getParameter("charge"));
		
		
		ChannelDao cd = new ChannelDao();
		Channel channel = new Channel();
		
		
		channel.setChannel_name(channelname);
		channel.setChannel_band(channelband);
		channel.setVideo_carrier_frequency(video);
		channel.setAudio_carrier_frequency(audio);
		channel.setChannel_charge_type(chargeType);
		channel.setChannel_transmission("transmission");
		channel.setChannel_charge(BigDecimal.valueOf(charge));
		
		
		
		boolean created = cd.create(channel);
		
		if(created == true) {
			response.getWriter().println("Channel Added");
			out.println("alert('Channel Created!');");
			response.sendRedirect("GetChannelServlet");
			
		}
		else {
			response.getWriter().println("Channel not Added");
		}
		
		
	}

}
