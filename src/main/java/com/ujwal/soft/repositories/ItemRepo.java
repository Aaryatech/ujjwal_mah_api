package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.ItemBean;

public interface ItemRepo extends JpaRepository<ItemBean, Integer>{
	@Query(value = "Select d.bill_detail_id, d.bill_header_id, d.part_id, p.part_name, d.ex_var1 as hsn_code, d.cgst_per,d.sgst_per, (d.cgst_per + d.sgst_per) as tax_per, sum(d.qty) as qty,sum(d.cgst_rs) as cgst, sum(d.sgst_rs) as sgst, sum(d.igst_rs) as igst, sum(d.taxable_amount) as taxable_amount, d.total_tax as total_tax, SUM(d.grand_total) as grand_total FROM bill_header h ,bill_details d, m_part p "
			+ " WHERE h.loc_id=:locationId AND h.company_id=:compId AND d.part_id =:itemId AND d.part_id=p.part_id AND d.bill_header_id=h.bill_header_id AND h.bill_date BETWEEN :fromDate AND :toDate GROUP BY d.part_id",nativeQuery=true)  
	
	public List<ItemBean> getItemByDateAndId(@Param("itemId") int itemId, @Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("compId") int compId, @Param("locationId") int locationId );
	
	
	@Query(value = "Select d.bill_detail_id, d.bill_header_id, d.part_id, p.part_name, d.ex_var1 as hsn_code, d.cgst_per,d.sgst_per, (d.cgst_per + d.sgst_per) as tax_per, sum(d.qty) as qty,sum(d.cgst_rs) as cgst, sum(d.sgst_rs) as sgst, sum(d.igst_rs) as igst, sum(d.taxable_amount) as taxable_amount, d.total_tax as total_tax, SUM(d.grand_total) as grand_total FROM bill_header h ,bill_details d, m_part p "
			+ " WHERE h.loc_id=:locationId AND h.company_id=:compId AND d.part_id=p.part_id AND d.bill_header_id=h.bill_header_id AND h.bill_date BETWEEN :fromDate AND :toDate GROUP BY d.part_id",nativeQuery=true)
	
	public List<ItemBean> getItemByDate(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("compId") int compId,@Param("locationId") int locationId);
}

//Select d.bill_detail_id, d.bill_header_id, d.part_id, p.part_name,t.hsn_code,t.cgst_per,t.sgst_per,t.igst_per, h.cust_id, c.cust_name, h.bill_date, (d.cgst_per + d.sgst_per) as tax_per, d.qty as qty, d.cgst_rs as cgst, d.sgst_rs as sgst, h.invoice_no, d.igst_rs as igst, d.taxable_amount as taxable_amount, d.total_tax as total_tax, d.grand_total as grand_total, d.ex_var1 FROM bill_header h ,bill_details d, m_part p, m_customer c,m_tax t "
//+ "WHERE h.loc_id=:locationId AND h.company_id=:compId AND d.bill_header_id=h.bill_header_id AND d.part_id=p.part_id AND h.bill_date BETWEEN :fromDate AND :toDate AND h.cust_id=c.cust_id AND t.tax_id=p.part_tax_id
/********************************************************************************************************************/
