package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.Stb;
import com.bean.StbType;
import com.dao.StbDao;
import com.dao.StbTypeDao;

/**
 * Servlet implementation class WriteSTBTypeServlet
 */
//@WebServlet("/WriteSTBTypeServlet")
@MultipartConfig
public class WriteSTBTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COMMA = ",";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteSTBTypeServlet() {
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
	
	private Function<String, Stb> mapToItem = (line) -> {

		  String[] p = line.split(COMMA);// a CSV has comma separated lines

		  Stb item = new Stb();

		  item.setSerial_num(p[0]);//<-- this is the first column in the csv file
		  item.setMac_id(p[1]);
		  item.setRemote_asset_id(p[2]);
		  item.setDish_asset_id(p[3]);
		  item.setStatus(p[4]);
		  item.setAssigned_retailer_id(Integer.parseInt(p[5]));
		  item.setAssigned_customer_id(Integer.parseInt(p[6]));

		  return item;

	};

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		StbType stbType = new StbType();
		stbType.setType(request.getParameter("type"));

		String featuresDemo = "";
		String feature[] = request.getParameterValues("features");

		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < feature.length; i++)
		{
			sb.append(feature[i] + ", ");
		}
		
		featuresDemo = sb.toString();
		stbType.setFeatures(featuresDemo);
		
		stbType.setLength(new BigDecimal(request.getParameter("length")));
		stbType.setBreadth(new BigDecimal(request.getParameter("breadth")));
		stbType.setWidth(new BigDecimal(request.getParameter("width")));
		stbType.setPrice(new BigDecimal(request.getParameter("price")));
		stbType.setInstall_charges(new BigDecimal(request.getParameter("install_charge")));
		stbType.setUpgrade_charge(new BigDecimal(request.getParameter("upgrade_charge")));
		stbType.setDiscount(Integer.parseInt(request.getParameter("discount")));
		stbType.setBilling_type(request.getParameter("billing_type"));
		stbType.setRefundable_deposit(new BigDecimal(request.getParameter("refundable_deposit")));


		StbTypeDao stbTypeDao = new StbTypeDao(); //for the type table
		StbDao stbDao = new StbDao(); //for the inventory table
		
		//File stuff:
		List<Stb> inputList = new ArrayList<Stb>();
		
		Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent = filePart.getInputStream();
	    BufferedReader br = new BufferedReader(new InputStreamReader(fileContent));
	    
	    inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList()); //skip header of csv file
	    //end file stuff. inputList contains a list of all the items to insert
	    boolean boxSuccess = false;
		if (stbTypeDao.create(stbType)) {
			System.out.println("Successfully created STB Type");
			for(Stb box : inputList) {
				box.setStb_type_id(stbType.getStb_type_id()); //This is the id of the item that was just created
				boxSuccess = stbDao.create(box);
			}
			if(boxSuccess) {
				HttpSession session = request.getSession();
				session.setAttribute("message", "STB Type and inventory created.");
				request.getRequestDispatcher("homepage.jsp").forward(request, response);
			} else {
				System.out.println("Unable to create STB inventory");
			}
		} else {
			System.out.println("Unable to create STB Type");
		}
	}

}
