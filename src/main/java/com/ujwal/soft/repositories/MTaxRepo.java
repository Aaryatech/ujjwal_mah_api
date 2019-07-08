
package com.ujwal.soft.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ujwal.soft.models.MTax;

public interface MTaxRepo extends JpaRepository<MTax, Integer> {

	@Query(value = "select * from m_tax where tax_id=:id",nativeQuery=true)
	public MTax  getTaxById(@Param ("id") int id);
	
	@Query(value = "SELECT * FROM m_tax WHERE del_status = 0 ORDER BY tax_id DESC",nativeQuery=true)
	public List<MTax> findAllTax();


	@Transactional
	@Modifying
	@Query(value="update m_tax set del_status = 1 where tax_id=:id",nativeQuery=true)
	public int deleteTax(int id);
	
	@Transactional
	@Modifying
	@Query(value="update m_tax set del_status = 1 where tax_id IN(:taxIds)",nativeQuery=true)
	int deleteMultiTax(@Param("taxIds") List<Integer> taxIds);

}
