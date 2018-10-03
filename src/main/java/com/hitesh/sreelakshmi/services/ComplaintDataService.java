package com.hitesh.sreelakshmi.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hitesh.sreelakshmi.db.ComplaintData;
import com.hitesh.sreelakshmi.info.UserSearchInput;
import com.hitesh.sreelakshmi.repository.ComplaintDataRepository;
import com.hitesh.sreelakshmi.repository.UserSpecificationsBuilder;

@Service
public class ComplaintDataService {

	@Autowired
	ComplaintDataRepository complaintDataRepository;


	public Optional<ComplaintData> getComplaintDataId(String id){

		return complaintDataRepository.findById(Long.valueOf(id));
	}

	public String saveInputData(ComplaintData dataInfo) {

		try {
			complaintDataRepository.saveAndFlush(dataInfo);
			return "DATA INSERTED SUCESSFULY";
		}catch(Exception e) {
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	public String updateInputData(ComplaintData dataInfo) {
		try {
			ComplaintData dbData = complaintDataRepository.getOne(Long.valueOf(dataInfo.getId()));
			ObjectMapper mapper = new ObjectMapper();
			Map<String,String> dbMap = mapper.convertValue(dbData, Map.class);
			Map<String,String> infoMap = mapper.convertValue(dataInfo, Map.class);
			for(String key:infoMap.keySet()) {
				if(!key.equals("id")) {
					String value = String.valueOf(infoMap.get(key));
					if(value!=null && !StringUtils.isEmpty(value)) {
						dbMap.put(key, value);
					}
				}
			}
			System.out.println(dbMap);
			complaintDataRepository.saveAndFlush(mapper.convertValue(dbMap, ComplaintData.class));
			return "DATA UPDATED SUCESSFULY";
		}catch(Exception e) {
			throw e;
		}
	}


	public List<ComplaintData> getAllData(){
		return complaintDataRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<ComplaintData> getData(UserSearchInput data){

		UserSpecificationsBuilder builder = new UserSpecificationsBuilder();
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> input = mapper.convertValue(data, Map.class);
		System.out.println(input);
		for(String key:input.keySet()) {
			if(input.get(key)!=null && !StringUtils.isEmpty(input.get(key))){
				System.out.println(input.get(key));
				builder.with(key,input.get(key));
			}
		}
		Specification<ComplaintData> spec = builder.build();
		return complaintDataRepository.findAll(spec);
	}


}
