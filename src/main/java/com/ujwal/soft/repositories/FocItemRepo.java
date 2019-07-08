package com.ujwal.soft.repositories;

import java.util.List;

import org.hibernate.boot.spi.JpaOrmXmlPersistenceUnitDefaultAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.FocItemBean;

public interface FocItemRepo extends JpaRepository<FocItemBean, Integer> {

	@Query(value = "SELECT UUID() AS id, h.invoice_no, h.bill_date, b.qty, b.mrp,b.part_id, p.part_name, p.part_uom_id, u.uom_name, b.grand_total FROM bill_header h, bill_details b, m_part p, m_uom u, m_location l, m_company c\n" + 
			"WHERE b.bill_header_id=h.bill_header_id AND h.loc_id=l.location_id AND l.location_id=:locationId AND h.company_id=c.comp_id AND c.comp_id=:compId AND b.part_id=p.part_id AND p.part_uom_id=u.uom_id AND h.bill_date BETWEEN :fromDate AND :toDate and b.grand_total=0",nativeQuery=true)
	List<FocItemBean> getFocItemByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate,@Param("compId") int compId,@Param("locationId") int locationId);

	@Query(value = "SELECT UUID() AS id, h.invoice_no, h.bill_date, b.qty, b.mrp,b.part_id, p.part_name, p.part_uom_id, u.uom_name, b.grand_total FROM bill_header h, bill_details b, m_part p, m_uom u, m_location l, m_company c "
			+ "WHERE b.part_id=:itemId AND b.bill_header_id=h.bill_header_id AND h.loc_id=l.location_id AND l.location_id=:locationId AND h.company_id=c.comp_id AND c.comp_id=:compId AND b.part_id=p.part_id AND p.part_uom_id=u.uom_id AND h.bill_date BETWEEN :fromDate AND :toDate and b.grand_total=0",nativeQuery=true)
	List<FocItemBean> getFocItemByDateAndId(int itemId, String fromDate, String toDate, int compId, int locationId);

}
