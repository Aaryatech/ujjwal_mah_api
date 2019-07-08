package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillReport;
import com.ujwal.soft.models.GetBillHeader;

public interface BillReportRepo extends JpaRepository<BillReport, Integer> {


	@Query(value = "SELECT b.bill_detail_id, m.cust_id,h.bill_header_id, m.cust_name,h.bill_date\n" + 
			"from bill_header h, m_customer m, bill_details b\n" + 
			"where h.cust_id=:custId AND h.cust_id=m.cust_id AND\n" + 
			"b.bill_header_id=h.bill_header_id AND \n" + 
			"h.bill_date BETWEEN :fromDate AND :toDate ",nativeQuery=true)
	List<BillReport> getBillHeadersByDate(@Param("custId")int custId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
