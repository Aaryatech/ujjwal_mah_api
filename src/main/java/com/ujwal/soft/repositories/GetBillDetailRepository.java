package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.GetBillDetail;

public interface GetBillDetailRepository extends JpaRepository<GetBillDetail, Integer>{

	@Query(value="select d.bill_detail_id,d.base_rate,d.bill_header_id,d.cess_per,d.cess_rs,d.cgst_per,d.cgst_rs,d.del_status,d.disc_per,d.disc_rs,d.ex_float1,d.ex_float2,\n" + 
			" d.ex_int1,d.ex_int2,d.ex_var1,d.ex_var2,d.grand_total,d.igst_per,d.igst_rs,d.mrp,d.part_id,p.part_name,t.hsn_code,u.uom_name,d.qty,d.remark,d.sgst_per,d.sgst_rs,d.taxable_amount,\n" + 
			"  d.total_tax from bill_details d,m_part p,m_uom u,m_tax t where t.tax_id=p.part_tax_id and d.part_id=p.part_id and u.uom_id=p.part_uom_id and d.del_status=0 and d.bill_header_id=:billHeaderId",nativeQuery=true)
	List<GetBillDetail> getBillDetailByHeaderId(@Param("billHeaderId")int billHeadId);

}
