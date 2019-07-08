package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MModelBean;

public interface MModelRepo extends JpaRepository<MModelBean, Integer> {

	@Query(value="SELECT * from m_model where del_status = 0 Order By model_id Desc",nativeQuery=true)
	List<MModelBean> findAllByDelStatus();

	MModelBean findByModelIdAndDelStatus(@Param("modelId") int modelId, int i);

	@Transactional
	@Modifying
	@Query(value="update m_model set del_status = 1 where model_id=:modelId",nativeQuery=true)
	int delModel(@Param("modelId") int modelId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_model SET del_status=1  WHERE model_id IN(:modelIds)",nativeQuery=true)
	public int deleteMultiModel(@Param("modelIds") List<Integer> modelIds);
	

	List<MModelBean> findAllByCompanyIdAndDelStatus(@Param("compId")int compId, int i);
}
