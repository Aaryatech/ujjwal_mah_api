/*package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ujwal.soft.models.MonthlyReport;

public interface GetMonthlyReportRepo extends JpaRepository<MonthlyReport, Integer> {
	
	@Query(value = "SELECT MONTHNAME(h.bill_date)as month, "+
			"h.bill_header_id,\r\n" + 
			"h.bill_date,\r\n" + 
			"h.company_id,\r\n" + 
			"c.comp_name,\r\n" + 
			"h.cust_id,\r\n" + 
			"h.invoice_no,\r\n" + 
			"cust.cust_name,\r\n" + 
			"h.loc_id,\r\n" + 
			"l.location_name,\r\n" + 
			"h.disc_amt,\r\n" + 
			"h.user_id,\r\n" + 
			"u.user_name,\r\n" + 
			"h.round_off,\r\n" +
			"h.tax_per,\r\n" + 
			 "SUM(h.taxable_amt) as taxable_amt ,"
			+ "sum(h.tota_tax) as total_tax,SUM(h.grand_total) "
			+ "AS grand_total ,h.round_off,SUM(h.sgst_amt)as sgst_amt ,"
			+ "SUM(h.cgst_amt) as cgst_amt ,SUM(h.igst_amt) as igst_amt,cust.cust_id,c.comp_id "
			+ "FROM bill_header h,m_user u,m_location l,m_company c,m_customer cust WHERE  c.comp_id=h.company_id and"
			+ "h.bill_date  BETWEEN  :fromDate AND :toDate and h.del_status=0 and h.user_id=u.user_id and l.location_id=h.loc_id"
			+ "AND h.del_status=0 GROUP BY month" ,nativeQuery = true)
	List<MonthlyReport> getBillBetweenDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate ,@RequestParam("compId") int compId);

}
   */