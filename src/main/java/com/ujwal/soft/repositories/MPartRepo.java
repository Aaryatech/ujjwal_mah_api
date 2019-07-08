package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MPart;

public interface MPartRepo extends JpaRepository<MPart, Integer> {

	@Query(value="SELECT * FROM m_part WHERE part_del_status = 0 AND comp_id=:compId ORDER BY part_id DESC",nativeQuery=true)
	List<MPart> findAllPart(@Param("compId") int compId);
//	SELECT * FROM m_part WHERE part_del_status = 0 ORDER BY part_id DESC
	
	MPart findByPartIdAndPartDelStatus(int id, int i);

	@Transactional
	@Modifying
	@Query(value="update m_part set part_del_status = 1 where part_id=:id",nativeQuery=true)
	public int deletePart(@Param("id") int id);

	@Transactional
	@Modifying
	@Query(value="update m_part set part_del_status = 1 where part_id IN(:partIds)",nativeQuery=true)
	int deleteMultiPart(@Param("partIds") List<Integer> custIds);

	@Query(value="SELECT * FROM m_part WHERE part_del_status = 0 and part_ro_no=:modelId ORDER BY part_id DESC",nativeQuery=true)
	List<MPart> getAllPartByModelId(@Param("modelId") int modelId);

	
	
	//int deleteMultiCompany(List<Integer> partIds);
}
