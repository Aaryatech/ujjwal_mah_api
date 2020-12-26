package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.GetPartsForBill;

public interface GetPartsForBillRepo extends JpaRepository<GetPartsForBill, Integer> {

	@Query(value="SELECT\n" + 
			"    part_id,\n" + 
			"    part_no,\n" + 
			"    part_name\n" + 
			"FROM\n" + 
			"    m_part\n" + 
			"WHERE\n" + 
			"    part_del_status = 0 AND part_ro_no = :modelId\n" + 
			"ORDER BY\n" + 
			"    part_id\n" + 
			"DESC", nativeQuery=true)
	List<GetPartsForBill> getAllPartByModelId(@Param("modelId") int modelId);
}
