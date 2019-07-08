package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ujwal.soft.models.TaxBillBean;

@Repository
public interface BillTaxRepo extends JpaRepository<TaxBillBean, Integer> {

	@Query(value = "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name,"
			+ " sum(bill.taxable_amount) as taxable_amt, (bill.cgst_per + bill.sgst_per) as tax_per,sum(bill.grand_total) as grand_total, "
			+ "cust.cust_gstn, sum(bill.cgst_rs) as cgst_amt, sum(bill.sgst_rs) as sgst_amt, sum(bill.igst_rs) as igst_amt, billhead.invoice_no,"
			+ " bill.ex_var1 FROM bill_details bill, bill_header billhead, m_customer cust WHERE billhead.loc_id=:locationId AND billhead.company_id =:comp_id"
			+ " AND bill.bill_header_id=billhead.bill_header_id AND billhead.bill_date BETWEEN :fromDate AND :toDate AND cust.cust_id = billhead.cust_id group by billhead.bill_header_id,(bill.cgst_per + bill.sgst_per), bill.ex_var1",nativeQuery=true)
	
	public List<TaxBillBean> getBillTaxReportById(@Param("comp_id") int comp_id, @Param("fromDate") String froDate, @Param("toDate") String toDate, @Param("locationId") int locationId);
	/*
	 * "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name, sum(bill.taxable_amount) as taxable_amt, (bill.cgst_per + bill.sgst_per) as tax_per,\r\n"
	 * + "			\r\n" +
	 * "			sum(bill.grand_total) as grand_total, cust.cust_gstn, sum(bill.cgst_rs) as cgst_amt, sum(bill.sgst_rs) as sgst_amt, sum(bill.igst_rs) as igst_amt, billhead.invoice_no, bill.ex_var1 \r\n"
	 * + "			\r\n" +
	 * "			FROM bill_details bill, bill_header billhead, m_customer cust\r\n"
	 * + "			\r\n" +
	 * "			WHERE billhead.loc_id=:locationId AND billhead.company_id =:comp_id AND bill.bill_header_id=billhead.bill_header_id AND billhead.bill_date BETWEEN :fromDate AND :toDate AND  cust.cust_id = billhead.cust_id\r\n"
	 * + "			\r\n" + " group by billhead.bill_header_id,tax_per, bill.ex_var1
	 */
	
	/******************************************************************************************************************************************************/
	
	  @Query(value =
	  "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name, sum(bill.taxable_amount) as taxable_amt, (bill.cgst_per + bill.sgst_per) as tax_per,\r\n"
	  + "			\r\n" +
	  "			sum(bill.grand_total) as grand_total, cust.cust_gstn, sum(bill.cgst_rs) as cgst_amt, sum(bill.sgst_rs) as sgst_amt, sum(bill.igst_rs) as igst_amt, billhead.invoice_no, bill.ex_var1 \r\n"
	  + "			\r\n" +
	  "			FROM bill_details bill, bill_header billhead, m_customer cust\r\n"
	  + "			\r\n" +
	  "			WHERE billhead.loc_id=:locationId AND bill.bill_header_id=billhead.bill_header_id AND billhead.bill_date BETWEEN :fromDate AND :toDate AND  cust.cust_id = billhead.cust_id\r\n"
	  + "			\r\n" +
	  "			group by   billhead.bill_header_id,tax_per, bill.ex_var1"
	  ,nativeQuery=true)
	  
	  public List<TaxBillBean> getBillTaxReport(@Param("fromDate") String
	  froDate, @Param("toDate") String toDate, @Param("locationId") int locationId);
	 

	@Query(value = "SELECT bill.bill_detail_id, billhead.bill_header_id, billhead.company_id, billhead.cust_id, billhead.bill_date, cust.cust_name, sum(bill.taxable_amount) as taxable_amt, (bill.cgst_per + bill.sgst_per) as tax_per,\r\n" + 
			"			sum(bill.grand_total) as grand_total, cust.cust_gstn, sum(bill.cgst_rs) as cgst_amt, sum(bill.sgst_rs) as sgst_amt, sum(bill.igst_rs) as igst_amt, billhead.invoice_no, bill.ex_var1\r\n" + 
			"					FROM bill_details bill, bill_header billhead, m_customer cust\r\n" + 
			"			WHERE bill.bill_header_id=billhead.bill_header_id AND billhead.bill_header_id IN(:billHeadIdList) AND  cust.cust_id = billhead.cust_id group by  tax_per, bill.bill_detail_id",nativeQuery=true)
	public List<TaxBillBean> getBillTaxReportByIds(@Param("billHeadIdList")List<Integer> billHeadIdList);



}
