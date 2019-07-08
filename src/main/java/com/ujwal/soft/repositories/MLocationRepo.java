package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.MLocComp;
import com.ujwal.soft.models.MLocation;

@Repository
public interface MLocationRepo extends JpaRepository<MLocation, Integer> {

	/*@Query(value="select * from m_location where location_id=:id",nativeQuery=true)
	public MLocation getLocationById(@Param ("id") int id);*/
	
	@Transactional
	@Modifying
	@Query(value="update m_location set del_status = 1 where location_id=:id",nativeQuery=true)
	public int deleteLocation(@Param("id") int id);
	
	public List<MLocation> findAllByCompIdAndDelStatus(@Param("companyId") int companyId, int i);

	public MLocation findByLocationIdAndDelStatus(int LocationId, int DelStatus);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_location SET del_status=1  WHERE location_id IN(:LocIds)",nativeQuery=true)
	public int deleteMultiLocation(@Param("LocIds") List<Integer> LocIds);

	public List<MLocation> findAllByDelStatus(int i);
		
}
