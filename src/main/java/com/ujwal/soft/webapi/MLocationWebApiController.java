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
import com.ujwal.soft.models.MLocation;
import com.ujwal.soft.repositories.MLocCompRepo;
import com.ujwal.soft.repositories.MLocationRepo;

@RestController
@RequestMapping("/ujwal")
public class MLocationWebApiController {

	@Autowired
	MLocationRepo mlocRepo;
	
	@RequestMapping(value="/addNewLocation", method=RequestMethod.POST)
	public@ResponseBody MLocation addNewLocation(@RequestBody MLocation mloc) {
		return mlocRepo.save(mloc);
		
	}
	
	
	@RequestMapping(value="/getAllLocationsByDel", method=RequestMethod.GET)
	public@ResponseBody List<MLocation> getAllLocation() {
		return mlocRepo.findAllByDelStatus(0);
		
	}
	
	@RequestMapping(value="/getAllLocations", method=RequestMethod.POST)
	public@ResponseBody List<MLocation> getAllLocation(@RequestParam("companyId") int companyId) {
		return mlocRepo.findAllByCompIdAndDelStatus(companyId, 0);
		
	}
	
	@RequestMapping(value="/getLocationById", method=RequestMethod.POST)
	public @ResponseBody MLocation getLocationId(@RequestParam("id") int id){
		return mlocRepo.findByLocationIdAndDelStatus(id, 0);
		
	}
	
	
	@RequestMapping(value="/deleteLocation", method=RequestMethod.POST)
	public@ResponseBody Info deleteLoc(@RequestParam int id) {
		
		Info info = new Info();
		
		int isDelete = mlocRepo.deleteLocation(id);
		
		if(isDelete!=0) {
			info.setError(false);
			info.setMessage("Sucess");
		}else {
			info.setError(true);
			info.setMessage("Fail");
		}
		
		return info;
	}
	
	@RequestMapping(value = { "/deleteMultiLocation" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteMultiLocation(@RequestParam("LocIds") List<Integer> LocIds) {

		Info info = new Info();

		try {
			int delete =mlocRepo.deleteMultiLocation(LocIds);

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
	MLocCompRepo mlocCampRepo;
	@RequestMapping(value = { "/getCompLoc" }, method = RequestMethod.GET)
	public @ResponseBody List getCompLoc() {
		return mlocCampRepo.getCompLoc();
	}
	
	
}
