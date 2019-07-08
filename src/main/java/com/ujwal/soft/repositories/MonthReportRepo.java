/*package com.ujwal.soft.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ujwal.soft.models.MonthlyReport;

@Repository
public interface MonthReportRepo extends JpaRepository<MonthlyReport, Integer>{

	@Query(value = "",nativeQuery=true)
	List<MonthlyReport> getMonthwiseReport(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

}
*/