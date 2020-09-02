package com.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Bill;
import com.bean.ChannelPackage;
import com.bean.Customer;
import com.bean.Stb;
import com.utilities.DbCon;

public class BillDao extends AbstractDao<Bill> {

	// 15 days, 24 hours per day, 60 minutes per hour, 60 s per minute, 1000 ms per s
	private static final long MILLISECONDS_IN_15_DAYS = (15 * 24 * 60 * 60 * 1000);

	@Override
	protected String getTableName() {
		return "CASE_Bill";
	}

	@Override
	protected Bill getNewBean() {
		return new Bill();
	}

	/**
	 * Updates the values in the Bill to reflect the charges for the given customer.
	 * The Bill should be passed to update() in order to store the generated bill.
	 * @param customer_id The customer ID
	 * @param bill The bill to generate
	 * @param other_charges Any other charges that will be added to the total pre-tax
	 * @return True if completed successfully; false otherwise
	 */
	public boolean generateForCustomer(int customer_id, Bill bill) {
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id);
		CustomerDao customerDao = new CustomerDao();
		if (!customerDao.read(customer)) {
			return false;
		}

		// Set customer name
		bill.setCustomer_name(customer.getEmail());

		// TODO Set STB type
		//bill.setStb_type("");

		// calculate package costs
		BigDecimal packageCostTotal = BigDecimal.ZERO;

		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
			packageCostTotal = packageCostTotal.add(cp.getPackage_cost());
		}

		String stbID = "0";
		BigDecimal setTopBoxCost = BigDecimal.ZERO;
		StbDao stbD = new StbDao();
		for (Stb stb : stbD.findAllP(customer_id)) {
			stbID = Integer.toString(stb.getStb_type_id());
			setTopBoxCost = stb.getPayable();
			System.out.println("Test 10: " + stbID + "Test 11: " + setTopBoxCost);
		}

		bill.setStb_type(stbID);

		// set other charges, tax and total
		bill.setOther_charges(setTopBoxCost);
		BigDecimal semitotal = packageCostTotal.add(setTopBoxCost);
		bill.setTax(semitotal.multiply(BigDecimal.valueOf(0.12)));
		bill.setTotal_amount(semitotal.add(bill.getTax()));

		// set generation and due dates
		long timeGenerated = System.currentTimeMillis();
		long timeDue = System.currentTimeMillis() + MILLISECONDS_IN_15_DAYS;
		bill.setGeneration_date(new Timestamp(timeGenerated));
		bill.setDue_date(new Timestamp(timeDue));

		return true;
	}

	public Bill findByIdB(int billId) {

		Connection con = DbCon.getConnection();
		Bill b = null;
		try
		{
			String qry = "SELECT * FROM "+"CASE_Bill"+ " "+
					"WHERE bill_id = ?";

			PreparedStatement st = con.prepareStatement(qry);
			st.setInt(1,billId);
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				b = new Bill();
				b.setCustomer_name(rs.getString("customer_name"));
				b.setStb_type(rs.getString("stb_type"));
				b.setOther_charges(rs.getBigDecimal("other_charges"));
				b.setTax(rs.getBigDecimal("tax"));
				b.setTotal_amount(rs.getBigDecimal("total_amount"));
				b.setGeneration_date(rs.getTimestamp("generation_date"));
				b.setDue_date(rs.getTimestamp("due_date"));
				//b.setBill_id(rs.getInt(billId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public ArrayList<Bill> findAllB() {
		// TODO Auto-generated method stub
		ArrayList<Bill> bills = new ArrayList<>();

		try
		{
			Connection con = DbCon.getConnection();
			//String qry = "SELECT * FROM CASE_Bill WHERE stb_type != 0";
			String qry = "SELECT * FROM ilp_case_study.case_bill WHERE stb_type != 0 AND bill_id IN (SELECT max(bill_id) FROM ilp_case_study.case_bill GROUP BY customer_name);";
			PreparedStatement st = con.prepareStatement(qry);

			ResultSet rs = st.executeQuery(qry);

			while(rs.next())
			{
				Bill obj = new Bill();
				obj.setBill_id(rs.getInt(1));
				obj.setCustomer_name(rs.getString(2));
				obj.setStb_type(rs.getString(3));
				obj.setOther_charges(rs.getBigDecimal(4));
				obj.setTax(rs.getBigDecimal(5));
				obj.setTotal_amount(rs.getBigDecimal(6));
				obj.setGeneration_date(rs.getTimestamp(7));
				obj.setDue_date(rs.getTimestamp(8));

				bills.add(obj);			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbCon.closeConnection();
		}

		return bills;
	}
	
	public void deleteExistingData()
	{
		try
		{
			Connection con = DbCon.getConnection();
			String qry = "DELETE FROM CASE_Bill";
			
			
			
			PreparedStatement st = con.prepareStatement(qry);
			st.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbCon.closeConnection();
		}

	}
	
	public Bill getBill(int id) {
		Bill obj = new Bill();

		Connection con = DbCon.getConnection();

		try {
			String qry = "select * from CASE_Bill where bill_id=?";
			PreparedStatement st = con.prepareStatement(qry);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				obj.setBill_id(rs.getInt(1));
				obj.setCustomer_name(rs.getString(2));
				obj.setStb_type(rs.getString(3));
				obj.setOther_charges(rs.getBigDecimal(4));
				obj.setTax(rs.getBigDecimal(5));
				obj.setTotal_amount(rs.getBigDecimal(6));
				obj.setGeneration_date(rs.getTimestamp(7));
				obj.setDue_date(rs.getTimestamp(8));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}

		return obj;
	}

}
