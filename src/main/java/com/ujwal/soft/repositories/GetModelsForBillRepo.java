package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.GetModelsForBill;

public interface GetModelsForBillRepo extends JpaRepository<GetModelsForBill, Integer> {

	@Query(value="SELECT\n" + 
			"    model_id,\n" + 
			"    model_name,\n" + 
			"    model_no\n" + 
			"FROM\n" + 
			"    `m_model`\n" + 
			"WHERE\n" + 
			"    company_id = :companyId AND del_status = 0\n" + 
			"ORDER BY\n" + 
			"    model_id\n" + 
			"DESC\n" + 
			"    ",nativeQuery=true)
	List<GetModelsForBill> getModelListForBill(@Param("companyId")int companyId);
}
