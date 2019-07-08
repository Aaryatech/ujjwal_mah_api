package com.ujwal.soft.webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ujwal.soft.models.MCompany;
import com.ujwal.soft.models.MGetPart;
import com.ujwal.soft.models.MPart;
import com.ujwal.soft.repositories.GetPartRepository;

@RestController
public class MGetPartApiController {
	
	@Autowired
	private GetPartRepository getRepository;
	
	@RequestMapping(value = { "/GetPartInfo" }, method = RequestMethod.POST)
	public @ResponseBody MGetPart getGetPartInfo(@RequestParam int id) {
		MGetPart part = getRepository.findByPart(id);
		return part;
		}
	
	@RequestMapping(value = { "/getAllPartList" }, method = RequestMethod.GET)
	public @ResponseBody List<MGetPart> getAllPartList() {
		return getRepository.getAllPartList();
	   
	}
	

	
}
