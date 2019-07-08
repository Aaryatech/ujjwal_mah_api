package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.GetCustomerTally;
import com.ujwal.soft.repositories.CustomerTallyRepo;

@RestController
public class CustomerTallyWebApiController {

	@Autowired
	CustomerTallyRepo custallyRepo;
	
	@RequestMapping(value="/getAllCustomerDetailsForTally", method=RequestMethod.POST)
	public@ResponseBody List<GetCustomerTally> getCustomerById(@RequestParam int companyId){
		
		List<GetCustomerTally> custList=custallyRepo.getCustomerListByCompId(companyId);
		System.err.println("CustList="+custList);
		return custList;
		
	}
}
