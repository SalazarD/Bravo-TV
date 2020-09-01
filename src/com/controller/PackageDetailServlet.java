package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Channel;
import com.bean.ChannelPackage;
import com.dao.ChannelPackageDao;

/**
 * Servlet implementation class PackageDetailServlet
 */
//@WebServlet("/PackageDetailServlet")
public class PackageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PackageDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ChannelPackageDao packagedao= new ChannelPackageDao();
		//get all category and sort
		Set<String> allCategory=packagedao.allCategory();
        List<String> sortedCategory = new ArrayList<String>(allCategory); 
        Collections.sort(sortedCategory); 
		session.setAttribute("allCategory", sortedCategory);
		//get all channel name
        List<Channel> allChannel =packagedao.getAllChannel();
		session.setAttribute("allChannel", allChannel);
		request.getRequestDispatcher("/channelPackage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("inserting ");
		ChannelPackage channelpack = new ChannelPackage();
		ChannelPackageDao packDao=new ChannelPackageDao();
		if(packDao.packageNameExist(request.getParameter("packageName"))==false) {
			channelpack.setPackage_name(request.getParameter("packageName"));
			channelpack.setPackage_category(request.getParameter("packageCategory"));
			channelpack.setPackage_charging_type(request.getParameter("packageType")); 
			channelpack.setPackage_transmission_type(request.getParameter("packageTrans"));
			channelpack.setPackage_cost(BigDecimal.valueOf(Double.parseDouble( request.getParameter("packageCostt"))));
			channelpack.setPackage_available_from_date(Timestamp.valueOf(request.getParameter("available_date")+" 00:00:00.00"));
			channelpack.setPackage_available_to_date(Timestamp.valueOf(request.getParameter("to_date")+" 00:00:00.00"));
			channelpack.setAdded_by_default(Boolean.parseBoolean(request.getParameter("addByDefault")));
			packDao.create(channelpack);
			String[] channelNameID=request.getParameterValues("allAvailableChannel");
			ArrayList<Integer> channelID=new ArrayList<Integer>();
			for(String channelInfo: channelNameID) {
				channelID.add(Integer.parseInt(channelInfo.substring(0,1)));
			}
			packDao.mappingChannelwithPack(channelpack.getPackage_id(), channelID);
			request.getRequestDispatcher("/PurchasePackage").forward(request, response);			
		}else {
			PrintWriter out = response.getWriter();
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Package name already exist, try a new package name');");
	        out.println("location='/BravoTV/ChannelPack/Add';");
	        out.println("</script>");
		}


	}

}
