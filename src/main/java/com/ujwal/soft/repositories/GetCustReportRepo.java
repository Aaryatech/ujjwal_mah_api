package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ujwal.soft.models.CustReport;

public interface GetCustReportRepo extends JpaRepository<CustReport, Integer>{

	@Query(value = "SELECT h.bill_header_id, h.company_id, h.bill_date,h.cust_id, c.cust_name, c.cust_gstn, h.cgst_amt, h.sgst_amt, h.igst_amt, h.tota_tax, h.invoice_no, h.taxable_amt, h.grand_total\r\n" + 
			"FROM bill_details b, bill_header h, m_customer c \r\n" + 
			"WHERE h.cust_id=:custId AND h.cust_id=c.cust_id AND h.company_id=:compId AND h.bill_header_id=b.bill_header_id AND h.bill_date BETWEEN :fromDate AND :toDate GROUP BY h.invoice_no",nativeQuery=true)
	List<CustReport> getCustBetweenDate(String fromDate, String toDate, int custId, int compId);

		
	@Query(value="SELECT h.bill_header_id, h.company_id, h.bill_date,h.cust_id, c.cust_name, c.cust_gstn, h.cgst_amt, h.sgst_amt, h.igst_amt, h.tota_tax, h.invoice_no, h.taxable_amt, h.grand_total "
			+ "FROM bill_details b, bill_header h, m_customer c WHERE h.cust_id=c.cust_id AND h.company_id=:compId AND h.bill_header_id=b.bill_header_id AND h.bill_date BETWEEN :fromDate AND :toDate GROUP BY h.invoice_no",nativeQuery=true)
	List<CustReport> getCustBetweenDate(String fromDate, String toDate, int compId);

}
