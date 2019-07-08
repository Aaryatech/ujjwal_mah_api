package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.GetBillHeader;

public interface GetBillHeaderRepository extends JpaRepository<GetBillHeader, Integer>{

/*	@Query(value="select h.bill_header_id,h.bill_date,h.cgst_amt,h.company_id,c.comp_name,h.cust_id,cust.cust_name,"
			
			+ "cust.cust_gstn,cust.cust_address,cust.cust_phone,cust.cust_pan,cust.cust_email,cust.cust_veh_no,"
			
			+ "cust.cust_vin_no,cust.cust_regis_no,cust.cust_model_no,h.igst_amt,h.disc_amt,h.invoice_no,h.loc_id,l.location_name,"
			
			+ " h.sgst_amt,h.tax_per,h.user_id,u.user_name,h.del_status,h.grand_total,h.remark,h.round_off,h.status,h.tota_tax,"
			
			+ "h.taxable_amt,h.bill_date_time,h.ex_int1,h.ex_int2,h.ex_float1,h.ex_float2,h.ex_var1,h.ex_var2 "
			
			+ "from bill_header h,m_user u, m_customer cust,m_company c,m_location l  "
			
			+ "where h.del_status=0 and h.user_id=u.user_id and cust.cust_id=h.cust_id and "
			
			+ "c.comp_id=h.company_id and l.location_id=h.loc_id and h.cust_id=:custId and h.bill_date>=:fromDate and h.bill_date<=:toDate",nativeQuery=true)
*/	
	
	@Query(value="select h.bill_header_id,h.bill_date,h.cgst_amt,h.company_id,c.comp_name,c.logo,c.email,l.phone_no,c.gstid,l.location_address as address,h.cust_id,cust.ex_int1 AS is_same_state, cust.cust_name,cust.cust_gstn,cust.cust_address,cust.cust_phone,cust.cust_pan,cust.cust_email,cust.cust_veh_no,cust.cust_model_no,cust.cust_regis_no,cust.cust_vin_no,h.igst_amt,h.disc_amt,h.invoice_no,h.loc_id,l.location_name, h.sgst_amt,h.tax_per,h.user_id,u.user_name,h.del_status,h.grand_total,h.remark,h.round_off,h.status,h.tota_tax,h.taxable_amt,h.bill_date_time,h.ex_int1,h.ex_int2,h.ex_float1,h.ex_float2,h.ex_var1,h.ex_var2,h.sale_type from bill_header h,m_user u,m_customer cust,m_company c,m_location l  where h.del_status=0 and h.user_id=u.user_id and cust.cust_id=h.cust_id and c.comp_id=h.company_id and l.location_id=h.loc_id and h.bill_header_id=:billHeaderId",nativeQuery=true)
	GetBillHeader getBillHeaderById(@Param("billHeaderId")int billHeadId);

	@Query(value="select h.bill_header_id,h.bill_date,h.cgst_amt,h.company_id,c.comp_name,c.logo,c.email,l.phone_no,c.gstid,l.location_address as address,h.cust_id,cust.ex_int1 AS is_same_state, cust.cust_name,cust.cust_gstn,cust.cust_address,cust.cust_phone,cust.cust_pan,cust.cust_email,cust.cust_veh_no,cust.cust_model_no,cust.cust_regis_no,cust.cust_vin_no,h.igst_amt,h.disc_amt,h.invoice_no,h.loc_id,l.location_name, h.sgst_amt,h.tax_per,h.user_id,u.user_name,h.del_status,h.grand_total,h.remark,h.round_off,h.status,h.tota_tax,h.taxable_amt,h.bill_date_time,h.ex_int1,h.ex_int2,h.ex_float1,h.ex_float2,h.ex_var1,h.ex_var2,h.sale_type from bill_header h,m_user u,m_customer cust,m_company c,m_location l  where h.del_status=0 and h.user_id=u.user_id and cust.cust_id=h.cust_id and c.comp_id=h.company_id and l.location_id=h.loc_id and h.bill_header_id IN(:billHeadIdList)",nativeQuery=true)
	List<GetBillHeader> findBillsByHeaderId(@Param("billHeadIdList")List<Integer> billHeadIdList);

	@Query(value="select h.bill_header_id,h.bill_date,h.cgst_amt,h.company_id,c.comp_name,c.logo,c.email,l.phone_no,c.gstid,l.location_address as address,h.cust_id,cust.ex_int1 AS is_same_state, cust.cust_name,cust.cust_gstn,cust.cust_address,cust.cust_phone,cust.cust_pan,cust.cust_email,cust.cust_veh_no,cust.cust_model_no,cust.cust_regis_no,cust.cust_vin_no,h.igst_amt,h.disc_amt,h.invoice_no,h.loc_id,l.location_name, h.sgst_amt,h.tax_per,h.user_id,u.user_name,h.del_status,h.grand_total,h.remark,h.round_off,h.status,h.tota_tax,h.taxable_amt,h.bill_date_time,h.ex_int1,h.ex_int2,h.ex_float1,h.ex_float2,h.ex_var1,h.ex_var2,h.sale_type from bill_header h,m_user u,m_customer cust,m_company c,m_location l  where h.del_status=0 and h.user_id=u.user_id and cust.cust_id=h.cust_id and c.comp_id=h.company_id and l.location_id=h.loc_id and h.loc_id=:locId and h.company_id=:compId and h.cust_id=:custId and h.bill_date between :fromDate and :toDate ORDER BY h.invoice_no DESC",nativeQuery=true)
	List<GetBillHeader> getBillHeadersByDate(@Param("locId")int locId,@Param("compId")int compId,@Param("custId") int custId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value="select h.bill_header_id,h.bill_date,h.cgst_amt,h.company_id,c.comp_name,c.logo,c.email,l.phone_no,c.gstid,l.location_address as address,h.cust_id,cust.ex_int1 AS is_same_state, cust.cust_name,cust.cust_gstn,cust.cust_address,cust.cust_phone,cust.cust_pan,cust.cust_email,cust.cust_veh_no,cust.cust_model_no,cust.cust_regis_no,cust.cust_vin_no,h.igst_amt,h.disc_amt,h.invoice_no,h.loc_id,l.location_name, h.sgst_amt,h.tax_per,h.user_id,u.user_name,h.del_status,h.grand_total,h.remark,h.round_off,h.status,h.tota_tax,h.taxable_amt,h.bill_date_time,h.ex_int1,h.ex_int2,h.ex_float1,h.ex_float2,h.ex_var1,h.ex_var2,h.sale_type from bill_header h,m_user u,m_customer cust,m_company c,m_location l  where h.del_status=0 and h.user_id=u.user_id and cust.cust_id=h.cust_id and c.comp_id=h.company_id and l.location_id=h.loc_id and h.loc_id=:locId and h.company_id=:compId and h.bill_date between :fromDate and :toDate ORDER BY h.invoice_no DESC",nativeQuery=true)
	List<GetBillHeader> getAllBillHeadersByDate(@Param("locId")int locId,@Param("compId")int compId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
			
}
