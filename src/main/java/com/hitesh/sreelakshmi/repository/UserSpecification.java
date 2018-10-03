package com.hitesh.sreelakshmi.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hitesh.sreelakshmi.db.ComplaintData;
import com.hitesh.sreelakshmi.info.SearchCriteria;

public class UserSpecification implements Specification<ComplaintData>{

	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;
	
	public  UserSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}
	
	@Override
	public Predicate toPredicate(Root<ComplaintData> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		if (root.get(criteria.getKey()).getJavaType() == String.class) {
            return builder.like(
              root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else {
            return builder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
	}
	

}
