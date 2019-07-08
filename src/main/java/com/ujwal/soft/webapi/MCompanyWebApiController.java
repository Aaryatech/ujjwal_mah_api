package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.Info;
import com.ujwal.soft.models.MCompany;
import com.ujwal.soft.repositories.MCompanyRepo;

@RestController
@RequestMapping("/ujwal")
public class MCompanyWebApiController {

	@Autowired
	MCompanyRepo mcompRepo;
	
	@RequestMapping(value="/addNewCompany", method=RequestMethod.POST)
	public@ResponseBody MCompany addNewCompany(@RequestBody MCompany mcomp) {
		return mcompRepo.save(mcomp);
	}
	
	@RequestMapping(value="/getAllCompanies", method=RequestMethod.GET)
	public@ResponseBody List<MCompany> gtAllCompanies(){
		return mcompRepo.getAllCompanies();
		
	}
	
	@RequestMapping(value="/getCompanyById", method=RequestMethod.POST)
	public@ResponseBody MCompany getCompanyById(@RequestParam int id){
		return mcompRepo.findByCompIdAndDelStatus(id, 0);
		
	}
	
	
	
	@RequestMapping(value="/deleteCompany", method=RequestMethod.POST)
	public @ResponseBody Info delCompany(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = mcompRepo.deleteCompany(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	@RequestMapping(value = { "/deleteMultiCompany" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCompany(@RequestParam("companyIds") List<Integer> companyIds) {

		Info info = new Info();

		try {
			int delete =mcompRepo.deleteMultiCompany(companyIds);

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
}
