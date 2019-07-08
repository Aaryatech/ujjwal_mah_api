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
import com.ujwal.soft.models.MUom;
import com.ujwal.soft.repositories.MUomRepo;

@RestController
@RequestMapping("/ujwal")
public class MUomWebApiController {

	@Autowired
	MUomRepo umomRepo;
	
	@RequestMapping(value="/addNewMUom", method=RequestMethod.POST)
	public@ResponseBody MUom addNewCompany(@RequestBody MUom muom) {
		return umomRepo.save(muom);
		
	}
	
	@RequestMapping(value="/getAllMUom", method=RequestMethod.GET)
	public@ResponseBody List<MUom> gtAllMUom(){
		return umomRepo.findAllUMom();
		
	}
	
	@RequestMapping(value="/getMUomById", method=RequestMethod.POST)
	public@ResponseBody MUom getUMomById(@RequestParam int id){
		return umomRepo.findByUomIdAndDelStatus(id, 0);
		
	}
	
	@RequestMapping(value="/deleteUMom", method=RequestMethod.POST)
	public @ResponseBody Info delUMom(@RequestParam int id) {
		
		Info info =new Info();
		int isDelete = umomRepo.deltUMom(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		return info;
		
	}
	
	@RequestMapping(value = { "/deleteMultiUom" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiCompany(@RequestParam("uomIds") List<Integer> uomIds) {

		Info info = new Info();

		try {
			int delete =umomRepo.deleteMultiUom(uomIds);

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
