package com.hitesh.sreelakshmi.repository;

import org.springframework.stereotype.Repository;

import com.hitesh.sreelakshmi.db.ComplaintData;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ComplaintDataRepository extends JpaRepository<ComplaintData, Long>{

	List<ComplaintData> findByLastName(String lastName);

	List<ComplaintData> findAll(Specification<ComplaintData> spec);

	
	
}
