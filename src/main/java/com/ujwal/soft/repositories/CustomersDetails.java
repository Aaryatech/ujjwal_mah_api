package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.MGetCustomerDetails;

@Repository
public interface CustomersDetails extends JpaRepository<MGetCustomerDetails, Integer> {

	@Query(value="SELECT m.cust_id, m.cust_del_status, m.cust_name, m.cust_address, m.cust_email, m.cust_phone,"
			+ " m.cust_veh_no, m.cust_model_no, m.cust_regis_no, m.cust_vin_no, d.model_name, d.model_id,"
			+ " c.comp_name, c.comp_id FROM m_customer m, m_company c, m_model d"
			+ " WHERE m.comp_Id=:companyId AND c.comp_id = m.comp_id AND m.cust_model_no = d.model_id AND  cust_del_status=0 ORDER BY cust_id DESC",nativeQuery=true)
	List<MGetCustomerDetails> findAllCustomerByDelStatus(@Param("companyId") int companyId);

}
