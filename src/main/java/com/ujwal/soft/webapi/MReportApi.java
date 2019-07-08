package com.ujwal.soft.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.common.DateConvertor;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.models.CompReport;
import com.ujwal.soft.models.CustReport;
import com.ujwal.soft.models.MonthlyReport;
import com.ujwal.soft.repositories.GetBillReportRepo;
import com.ujwal.soft.repositories.GetCustReportRepo;
//import com.ujwal.soft.repositories.GetMonthlyReportRepo;

@RestController
@RequestMapping("/ujwal")
public class MReportApi {
	@Autowired
	GetBillReportRepo getBillReportReportrepo;
	@Autowired
	GetCustReportRepo getCustReportRepo;
	/*@Autowired
	GetMonthlyReportRepo getmonthlyReportReportrepo;*/
	
	@RequestMapping(value = { "/getContractorBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<CompReport> getContractorBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate ,@RequestParam("compId") int compId, @RequestParam("locationId") int locationId ) {
          System.out.println("aZSxdcfgvbhjnmk");
		List<CompReport> headerList = new ArrayList<CompReport>();

		
			System.out.println(compId+" "+fromDate+" "+toDate+" "+locationId);
			if(compId<=0) {
			headerList = getBillReportReportrepo.getBillBetweenDate(fromDate, toDate);
			System.out.println("Response Data1="+headerList);
			}else {
			
				headerList = getBillReportReportrepo.getBillBetweenDate(fromDate, toDate, compId, locationId);
				System.out.println("Response Data2="+headerList);
			}
				return headerList;

	}
	
	
	@RequestMapping(value = { "/getCustomerBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<CustReport> getCustomerBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate ,@RequestParam("custId") int custId, @RequestParam("compId") int compId ) {
          System.out.println("aZSxdcfgvbhjnmk");
		List<CustReport> headerList = new ArrayList<CustReport>();

		try {
			System.out.println("Customerrr Id="+custId);
			if(custId<=0) {
				headerList = getCustReportRepo.getCustBetweenDate(fromDate, toDate,compId);
				System.out.println("Service Responce="+headerList);
			}else {
			headerList = getCustReportRepo.getCustBetweenDate(fromDate, toDate, custId,compId);
			System.out.println("Service Responce="+headerList);
			}
		
		} catch (Exception e) {
			

			e.printStackTrace();

		}
		return headerList;

	}


	/*@RequestMapping(value = { "/getMonthlyBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<MonthlyReport> getMonthlyBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate ,@RequestParam("compId") int compId ) {
    //      System.out.println("aZSxdcfgvbhjnmk");
		List<MonthlyReport> headerList = new ArrayList<MonthlyReport>();

		try {
			System.out.println(compId);

			headerList = getmonthlyReportReportrepo.getBillBetweenDate(fromDate, toDate, compId);
			System.out.println(headerList.toString());
		
		} catch (Exception e) {

			e.printStackTrace();

		}
		return headerList;
*/
	//}
}
