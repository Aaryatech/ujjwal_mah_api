package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MCompany;
import com.ujwal.soft.models.MCustomer;
import com.ujwal.soft.models.MGetCustomerDetails;
import com.ujwal.soft.repositories.CustomersDetails;
import com.ujwal.soft.repositories.MCustomerRepo;

@RestController
@RequestMapping("/ujwal")
public class MCustomerWebApiController {
	@Autowired
	MCustomerRepo mcustRepo;
	
	@RequestMapping(value="/addNewCustomer", method=RequestMethod.POST)
	public@ResponseBody MCustomer addNewCustomer(@RequestBody MCustomer mcust) {
		return mcustRepo.save(mcust);
		
	}
	
	@RequestMapping(value="/getAllCustomer", method=RequestMethod.GET)
	public@ResponseBody List<MCustomer> getAllCustomer(){
		return mcustRepo.findAllByCustDelStatus();
		
	}
	
	@RequestMapping(value="/getCustomerById", method=RequestMethod.POST)
	public@ResponseBody MCustomer getCustomerById(@RequestParam int id){
		return mcustRepo.findByCustIdAndCustDelStatus(id, 0);
		
	}
	
	
	
	@RequestMapping(value="/deleteCustomerId", method=RequestMethod.POST)
	public @ResponseBody Info delCustomer(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = mcustRepo.deleteCustomer(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	@RequestMapping(value = { "/deleteMultiCustomer" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCustomer(@RequestParam("custIds") List<Integer> custIds) {

		Info info = new Info();

		try {
			int delete = mcustRepo.deleteMultiCompany(custIds);

			if (delete >= 1) {
				info.setError(false);
				info.setMessage("successfully Multiple Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}
	
	@Autowired
	CustomersDetails customerDetail;
	@RequestMapping(value="/getAllCustomerDetails", method=RequestMethod.POST)
	public@ResponseBody List<MGetCustomerDetails> getAllCustomerDetails(@RequestParam("companyId") int companyId){
		return customerDetail.findAllCustomerByDelStatus(companyId);
		
	}
	
	@RequestMapping(value="/getCustomerByCompId", method=RequestMethod.POST)
	public@ResponseBody List<MCustomer> getCustomerByCompId(@RequestParam int id){
		return mcustRepo.findAllCustomerByCustDelStatusAndCompId(0, id);
		
	}
}
