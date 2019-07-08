package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.GetBillDetail;
import com.ujwal.soft.models.GetBillHeader;
import com.ujwal.soft.models.ItemBean;
import com.ujwal.soft.models.TaxBillBean;
import com.ujwal.soft.repositories.BillTaxRepo;

@RestController
@RequestMapping(value = "/ujwal")
public class TaxBillWebApiController {

	@Autowired BillTaxRepo billtxRepo;
	@RequestMapping(value = "/getBillTaxReport", method=RequestMethod.POST)
	
	public List<TaxBillBean> getTaxWiseBilleport(@RequestParam("comp_id") int comp_id, @RequestParam("fromDate") String froDate, 
			@RequestParam("toDate") String toDate, @RequestParam("locationId") int locationId){
		
		
		List<TaxBillBean> taxList=null;
		taxList = billtxRepo.getBillTaxReportById(comp_id, froDate, toDate, locationId);
//		if(comp_id==0)
//		{
//			System.err.println("1");
//			taxList = billtxRepo.getBillTaxReport(froDate, toDate, locationId);
//			
//		}
//		else {
//			System.err.println("2");
//			taxList = billtxRepo.getBillTaxReportById(comp_id, froDate, toDate, locationId);
//		}
		
		
				return taxList;
		
	}
	
	
	@RequestMapping(value = { "/findXmlBillsByHeaderId" }, method = RequestMethod.POST)
	public @ResponseBody List<TaxBillBean> findXmlBillsByHeaderId(@RequestParam("billTempIds")List<Integer> billHeadIdList) {


		List<TaxBillBean> taxList=null;

		try {
			
			taxList = billtxRepo.getBillTaxReportByIds(billHeadIdList);
		} catch (Exception e) {

			e.printStackTrace();

		}

		return taxList;

	}
}
