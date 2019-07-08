/*package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.MonthlyReport;
import com.ujwal.soft.repositories.MonthReportRepo;

@RestController
@RequestMapping("/ujwal")
public class MonthlyReportWebApi  {

	@Autowired MonthReportRepo mthRepo;
	
	@RequestMapping(value = "/getMonthlyReport", method=RequestMethod.POST)
	
	public List<MonthlyReport> getMonthwiseReport(@RequestParam ("fromDate") String fromDate, @RequestParam ("todate") String toDate){
		return mthRepo.getMonthwiseReport(fromDate, toDate);
		
	}
}
*/