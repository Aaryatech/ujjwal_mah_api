package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.MLocComp;

@Repository
public interface MLocCompRepo extends JpaRepository<MLocComp, Integer> {

	/*@Query(value="SELECT loc.location_id, loc.location_name, loc.location_address, loc.email, loc.phone_no,loc.del_status,loc.fax_no, comp.comp_id, comp.comp_name\r\n" + 
			"FROM  m_location loc, m_company comp WHERE loc.del_status=0 and loc.location_id=comp.comp_id",nativeQuery=true)
	*/
	
	
	@Query(value="SELECT loc.location_id, loc.location_name, loc.location_address, loc.email, loc.phone_no,loc.del_status,loc.fax_no, comp.comp_id, comp.comp_name\r\n" + 
			"FROM  m_location loc, m_company comp WHERE loc.del_status=0 and loc.comp_id=comp.comp_id GROUP BY loc.location_id ORDER BY location_id DESC",nativeQuery=true)
	public List<MLocComp> getCompLoc();
}
