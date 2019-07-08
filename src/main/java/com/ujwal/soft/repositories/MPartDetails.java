package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MPartList;

public interface MPartDetails extends JpaRepository<MPartList, Integer> {

	@Query(value="SELECT p.part_id, p.part_tax_id, p.part_name, p.part_no, p.part_register_no, p.part_specification, p.part_uom_id, p.part_ro_no, p.part_del_status, p.part_mrp,\r\n" + 
			"t.tax_desc, t.tax_id,\r\n" + 
			"u.uom_name, u.uom_id, \r\n" + 
			"m.comp_id, m.comp_name, d.model_name, d.model_id\r\n" + 
			"FROM m_part p, m_tax t, m_uom u, m_company m, m_model d \r\n" + 
			"WHERE p.part_del_status = 0 AND p.part_tax_id = t.tax_id AND p.part_ro_no = d.model_id \r\n" + 
			"AND p.part_uom_id = u.uom_id \r\n" + 
			"AND p.comp_id = m.comp_id AND m.comp_id=:companyId ORDER BY part_id DESC",nativeQuery=true)
	List<MPartList> getAllPartDetail(@Param ("companyId") int companyId);
}
