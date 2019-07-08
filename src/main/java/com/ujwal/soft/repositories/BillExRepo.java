package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.ujwal.soft.models.BillExcell;

public interface BillExRepo extends JpaRepository<BillExcell, Integer> {

	@Query(value="SELECT UUID() AS id,d.bill_header_id,h.invoice_no, h.bill_date,cust.ex_int1 AS is_same_state, cust.cust_name,m.model_name, sum(d.taxable_amount) AS taxable_amt , d.cgst_per, d.sgst_per, (d.cgst_per+d.sgst_per) AS igst_per, SUM(d.sgst_rs) AS sgst_amt, SUM(d.cgst_rs) AS cgst_amt, SUM(d.sgst_rs+d.cgst_rs) AS total_tax, h.grand_total AS invoice_amt, cust.cust_gstn as gst_no,cust.cust_phone AS mob_no,cust.cust_address AS address FROM bill_header h, bill_details d, m_customer cust, m_model m, m_part p, m_company c WHERE d.del_status=0 AND h.cust_id=cust.cust_id AND p.part_id=d.part_id AND p.part_ro_no=m.model_id AND d.bill_header_id=h.bill_header_id AND h.company_id=c.comp_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.loc_id=:compId GROUP BY d.bill_header_id, p.part_ro_no, (d.cgst_per+d.sgst_per)",nativeQuery=true)
	public List<BillExcell> getBillDataByDateAndCompId(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("compId") int compId);

	
	@Query(value="SELECT UUID() AS id,d.bill_header_id,h.invoice_no, h.bill_date,cust.ex_int1 AS is_same_state, cust.cust_name,m.model_name, sum(d.taxable_amount) AS taxable_amt , d.cgst_per, d.sgst_per, (d.cgst_per+d.sgst_per) AS igst_per, SUM(d.sgst_rs) AS sgst_amt, SUM(d.cgst_rs) AS cgst_amt, SUM(d.sgst_rs+d.cgst_rs) AS total_tax, SUM(d.grand_total) AS invoice_amt, cust.cust_gstn as gst_no,cust.cust_phone AS mob_no,cust.cust_address AS address FROM bill_header h, bill_details d, m_customer cust, m_model m, m_part p, m_company c WHERE d.del_status=0 AND h.cust_id=cust.cust_id AND p.part_id=d.part_id AND d.ex_int1=m.model_id AND d.bill_header_id=h.bill_header_id AND h.company_id=c.comp_id AND d.ex_int1=:modelId AND h.bill_date BETWEEN :fromDate AND :toDate AND h.loc_id=:locationId GROUP BY d.bill_header_id,d.ex_int1",nativeQuery=true)
	public List<BillExcell> getModelSaleByLocIdAndModId(@Param("fromDate") String fromDate, @Param("toDate") String toDate, @Param("locationId") int locationId, @Param("modelId") int modelId);
}

//SELECT UUID() AS id,d.bill_header_id,h.invoice_no, h.bill_date, cust.cust_name,m.model_name, sum(d.taxable_amount) AS taxable_amt , d.cgst_per, d.sgst_per, (d.cgst_per+d.sgst_per) AS igst_per, SUM(d.sgst_rs) AS sgst_amt, SUM(d.cgst_rs) AS cgst_amt, SUM(d.sgst_rs+d.cgst_rs) AS total_tax, SUM(d.grand_total) AS invoice_amt FROM bill_header h, bill_details d, m_customer cust, m_model m, m_part p, m_company c WHERE d.del_status=0 AND h.cust_id=cust.cust_id AND p.part_id=d.part_id AND p.part_ro_no=m.model_id AND d.bill_header_id=h.bill_header_id AND h.company_id=c.comp_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.loc_id=:compId GROUP BY d.bill_header_id, p.part_ro_no, (d.cgst_per+d.sgst_per)