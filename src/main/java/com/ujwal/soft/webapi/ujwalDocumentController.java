package com.ujwal.soft.webapi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ujwal.soft.models.Document;
import com.ujwal.soft.models.Info;
import com.ujwal.soft.repositories.DocumentRepo;


public class ujwalDocumentController {
	
	@Autowired
	DocumentRepo getDocumentRepo;
	@RequestMapping(value = { "/saveDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document saveDocument(@RequestBody Document document) {

		Document res = new Document();

		try {

			res = getDocumentRepo.saveAndFlush(document);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getAllDocList" }, method = RequestMethod.GET)
	public @ResponseBody List<Document> getAllDocList() {

		List<Document> docList = new ArrayList<Document>();

		try {

			docList = getDocumentRepo.findByDelStatusOrderByDocIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return docList;

	}
/*
	@RequestMapping(value = { "/getDocument" }, method = RequestMethod.POST)
	public @ResponseBody Document getDocument(@RequestParam("locationId") int locationId,@RequestParam("docCode") int docCode) {

		Document doc = new Document();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = dateFormat.format(new Date());

		try {

			doc = getDocumentRepo.getDocuData(locationId,docCode, curDate);
			System.err.println("getting doc " + doc.toString());

		} catch (Exception e) {
			System.err.println("Exc in  /getDocument" + e.getMessage());
			e.printStackTrace();

		}

		return doc;

	}
	@RequestMapping(value = { "/updateDocSrNo" }, method = RequestMethod.POST)
	public @ResponseBody Info updateDocSrNo(@RequestParam("locationId") int locationId,@RequestParam("docCode") int docCode, @RequestParam("srNo") int srNo) {

		Info info = new Info();

		try {

			int update = getDocumentRepo.updateDocSrNo(locationId,srNo, docCode);

			if (update == 1) {
				info.setError(false);
				info.setMessage("successfully update");
			} else {
				info.setError(true);
				info.setMessage(" failed to update");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" failed to update");

		}
		return info;

	}*/
}
