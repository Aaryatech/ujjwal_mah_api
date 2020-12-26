package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.GetCustForBill;

public interface GetCustForBillRepo extends JpaRepository<GetCustForBill, Integer> {

	@Query(value="SELECT\r\n" + 
			"    cust_id,\r\n" + 
			"    cust_name,\r\n" + 
			"    cust_vin_no,\r\n" + 
			"    cust_veh_no\r\n" + 
			"FROM\r\n" + 
			"    `m_customer`\r\n" + 
			"WHERE\r\n" + 
			"    cust_del_status = 0 AND comp_id = :companyId\r\n" + 
			"ORDER BY\r\n" + 
			"    cust_id\r\n" + 
			"DESC\r\n" + 
			"    ",nativeQuery=true)
	List<GetCustForBill> getCustomerForBill(@Param("companyId") int id);
}
