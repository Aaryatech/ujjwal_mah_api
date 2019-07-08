package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillExcell;
import com.ujwal.soft.repositories.BillDetailRepo;
import com.ujwal.soft.repositories.BillExRepo;

@RestController
public class BillExcellController {

	@Autowired
	BillExRepo billexrepo;
	
	@RequestMapping(value= {"/getBilltoExecll"}, method=RequestMethod.POST)
	public @ResponseBody List<BillExcell>getBilltoExecll(@RequestParam("fromDate") String fromDate, 
			@RequestParam("toDate") String toDate, @RequestParam("compId") int compId){
		
		List<BillExcell> bilexlList = billexrepo.getBillDataByDateAndCompId(fromDate, toDate, compId);
		
		System.err.println("BillExcel List:"+bilexlList);
		
		return bilexlList;
		
	}
	
	@RequestMapping(value= {"/getModelSalesReport"}, method=RequestMethod.POST)
	public @ResponseBody List<BillExcell>getModelSalesReport(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,
			@RequestParam("modelId") int modelId, @RequestParam("locationId") int locationId){
		
		List<BillExcell> modelSaleList = billexrepo.getModelSaleByLocIdAndModId(fromDate, toDate, locationId, modelId);
		
		System.err.println("BillExcel List:"+modelSaleList);
		
		return modelSaleList;
		
	}
}
