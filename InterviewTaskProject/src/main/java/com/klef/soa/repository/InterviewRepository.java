package com.klef.soa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Long>{
      List<Interview> findByName(String name);
      List<Interview> findByType(String type);

	
}
