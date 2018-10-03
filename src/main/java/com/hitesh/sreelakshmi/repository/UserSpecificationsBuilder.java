package com.hitesh.sreelakshmi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.hitesh.sreelakshmi.db.ComplaintData;
import com.hitesh.sreelakshmi.info.SearchCriteria;

@SuppressWarnings("deprecation")
public class UserSpecificationsBuilder {
	
	
	private final List<SearchCriteria> params;
	 
    public UserSpecificationsBuilder() {
        params = new ArrayList<>();
    }
    
    public UserSpecificationsBuilder with(String key, Object value) {
        params.add(new SearchCriteria(key,value));
        return this;
    }
    
 
	public Specification<ComplaintData> build() {
        if (params.size() == 0) {
            return null;
        }
 
        List<Specification<ComplaintData>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new UserSpecification(param));
        }
 
        Specification<ComplaintData> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }

}
