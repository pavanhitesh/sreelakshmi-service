package com.hitesh.sreelakshmi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hitesh.sreelakshmi.db.ComplaintData;
import com.hitesh.sreelakshmi.info.UserSearchInput;
import com.hitesh.sreelakshmi.services.ComplaintDataService;

@RestController
public class TestController {
	
	@Autowired
	ComplaintDataService complaintDataService;

	@RequestMapping(value ="/home",method=RequestMethod.GET)
	public String getApplication() {
		return "Application Running";
	}
	
	@RequestMapping(value="/getData" ,method = RequestMethod.GET)
	public Optional<ComplaintData> getComplaintData(@RequestParam String id){
		return complaintDataService.getComplaintDataId(id);
	}
	@RequestMapping(value="/getAllData" ,method = RequestMethod.GET)
	public List<ComplaintData> getAllComplaintData(){
		return complaintDataService.getAllData();
	}
	
	@RequestMapping(value="/getComplaintsData" ,method = RequestMethod.POST)
	public List<ComplaintData> getAllComplaintData(@RequestBody UserSearchInput data){
		return complaintDataService.getData(data);
	}
	
	@RequestMapping(value="/saveData",method = RequestMethod.POST)
	public String saveData(@RequestBody ComplaintData dataInfo) {
		return complaintDataService.saveInputData(dataInfo);
	}
	
	@RequestMapping(value="/updateData",method = RequestMethod.POST)
	public String updateData(@RequestBody ComplaintData dataInfo) {
		return complaintDataService.updateInputData(dataInfo);
	}
	
	
}
