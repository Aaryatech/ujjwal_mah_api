package com.ujwal.soft.webapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.BillDetails;
import com.ujwal.soft.models.BillHeader;
import com.ujwal.soft.models.FocItemBean;
import com.ujwal.soft.models.ItemBean;
import com.ujwal.soft.repositories.BillDetailRepo;
import com.ujwal.soft.repositories.FocItemRepo;
import com.ujwal.soft.repositories.ItemRepo;

@RestController
@RequestMapping("/ujwal")
public class ItemReportWebApi {

	
	@Autowired ItemRepo itemRepo;
	
	@Autowired FocItemRepo focRepo;
	
	@RequestMapping(value = "/getItemsBetweenDate", method=RequestMethod.POST)
	public @ResponseBody List<ItemBean>  getItemsBetweenDate(@RequestParam("itemId") int itemId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("compId") int compId,  @RequestParam("locationId") int locationId){
		
		List<ItemBean> itemList=null;
		if(itemId==0)
		{
			itemList=itemRepo.getItemByDate(fromDate, toDate, compId, locationId);
		}
		else {
			itemList=itemRepo.getItemByDateAndId(itemId, fromDate, toDate, compId, locationId);
		}
		return itemList;
		
	}
	
	@RequestMapping(value = "/getAllFocPart", method=RequestMethod.POST)
	public @ResponseBody List<FocItemBean>  getAllFocPart(@RequestParam("itemId") int itemId, @RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("compId") int compId,  @RequestParam("locationId") int locationId){
		
		List<FocItemBean> focItemList=null;
		if(itemId==0)
		{
			focItemList=focRepo.getFocItemByDate(fromDate, toDate, compId, locationId);
			System.err.println("FocList="+focItemList);
		}
		else {
			focItemList=focRepo.getFocItemByDateAndId(itemId, fromDate, toDate, compId, locationId);
		}
		return focItemList;
		
	}
}
