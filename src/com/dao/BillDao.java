package com.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.bean.Bill;
import com.bean.ChannelPackage;
import com.bean.Customer;

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
	 * @param otherCharges Any other charges that will be added to the total pre-tax
	 * @return True if completed successfully; false otherwise
	 */
	public boolean generateForCustomer(int customer_id, Bill bill, BigDecimal other_charges) {
		Customer customer = new Customer();
		customer.setCustomer_id(customer_id);
		CustomerDao customerDao = new CustomerDao();
		if (!customerDao.read(customer)) {
			return false;
		}
		
		// Set customer name
		bill.setCustomer_name(customer.getFirst_name() + " " + customer.getLast_name());
		
		// TODO Set STB type
		//bill.setStb_type("");
		
		// calculate package costs
		BigDecimal packageCostTotal = BigDecimal.ZERO;
		
		PurchaseMapDao purchaseDao = new PurchaseMapDao();
		for (ChannelPackage cp : purchaseDao.getPurchasedPackages(customer_id)) {
			packageCostTotal = packageCostTotal.add(cp.getPackage_cost());
		}
		
		// set other charges, tax and total
		bill.setOther_charges(other_charges);
		BigDecimal semitotal = packageCostTotal.add(other_charges);
		bill.setTax(semitotal.multiply(BigDecimal.valueOf(0.12)));
		bill.setTotal_amount(semitotal.add(bill.getTax()));
		
		// set generation and due dates
		long timeGenerated = System.currentTimeMillis();
		long timeDue = System.currentTimeMillis() + MILLISECONDS_IN_15_DAYS;
		bill.setGeneration_date(new Timestamp(timeGenerated));
		bill.setDue_date(new Timestamp(timeDue));
		
		return true;
	}
}
