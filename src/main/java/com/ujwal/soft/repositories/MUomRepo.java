package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MUom;

public interface MUomRepo extends JpaRepository<MUom, Integer> {
	
	@Query(value="SELECT * FROM m_uom WHERE del_status = 0 ORDER BY uom_id DESC",nativeQuery=true)
	List<MUom> findAllUMom();
	
	MUom findByUomIdAndDelStatus(int uomId,int delStatus);


	@Transactional
	@Modifying
	@Query(value="update m_uom set del_status = 1 where uom_id=:id",nativeQuery=true)
	public int deltUMom(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_uom SET del_status=1  WHERE uom_id IN(:uomIds)",nativeQuery=true)
	int deleteMultiUom(@Param("uomIds") List<Integer> uomIds);

	
}
