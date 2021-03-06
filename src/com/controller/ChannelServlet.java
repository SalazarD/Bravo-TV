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
import com.dao.ChannelPackageDao;

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
		//Channel channel = new Channel();
		//ChannelDao cd = new ChannelDao();
		
		
		String deleteId = request.getParameter("deleteId");
		if (deleteId != null) {
			Integer id = Integer.parseInt(deleteId);
			System.out.println(deleteId);
			ChannelDao cd = new ChannelDao();
			Channel c = new Channel();
			c.setChannel_id(id);
			cd.delete(c);
			response.sendRedirect("./GetChannelServlet");
		}
		
		
        
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChannelDao cd = new ChannelDao();
		Channel channel = new Channel();
		
//		boolean num =request.getParameter("reqDelete") != null;
//
//		if(num == true) {
//
//			int del = Integer.parseInt(request.getParameter("id"));
//			channel.setChannel_id(del);
//			boolean deleted = cd.delete(channel);
//
//			if (deleted == true) {
//				System.out.println("delete success");
//			}
//			else {
//				System.out.println("error somewhere");
//			}
//
//		}
		
		
			//doGet(request, response);
			//PrintWriter out = response.getWriter();
			String channelname = request.getParameter("channelName");
			String channelband = request.getParameter("channelBand");

			int video = Integer.parseInt(request.getParameter("video"));
			int audio = Integer.parseInt(request.getParameter("audio"));
			String chargeType = request.getParameter("chargeType");
			Double charge = Double.parseDouble(request.getParameter("charge"));
			
			
			
			
			
			channel.setChannel_name(channelname);
			channel.setChannel_band(channelband);
			channel.setVideo_carrier_frequency(video);
			channel.setAudio_carrier_frequency(audio);
			channel.setChannel_charge_type(chargeType);
			channel.setChannel_transmission("transmission");
			channel.setChannel_charge(BigDecimal.valueOf(charge));
			
			String action = request.getParameter("action");
			
			
			if(action.equals("add")) {
				cd.create(channel);
				
				HttpSession session = request.getSession();
				session.setAttribute("message", "Channel added!");
				request.getRequestDispatcher("GetChannelServlet").forward(request, response);
			}
			
			else if(action.equals("update")) {
				
				// Get channel ID
				int channel_id = Integer.parseInt(request.getParameter("channelId"));
				
				// Need old details...
				Channel oldDetails = new Channel();
				oldDetails.setChannel_id(channel_id);
				cd.read(oldDetails);
				
				// Set new details...
				channel.setChannel_id(channel_id);
				cd.update(channel);
				
				// Update packages associated with this channel
				BigDecimal oldCost = oldDetails.getChannel_charge();
				BigDecimal newCost = channel.getChannel_charge();
				new ChannelPackageDao().updatePackageCostsHavingChannel(channel_id, oldCost, newCost);
				
				HttpSession session = request.getSession();
				session.setAttribute("message", "Channel updated.");
				request.getRequestDispatcher("GetChannelServlet").forward(request, response);
			}
			
		
		
		
		
		//boolean created = cd.create(channel);
		
		/*if(created == true) {
			response.getWriter().println("Channel Added");
			out.println("alert('Channel Created!');");
			response.sendRedirect("GetChannelServlet");
			
		}
		else {
			response.getWriter().println("Channel not Added");
		}*/
		
		
	}

}
