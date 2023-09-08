package com.jamie.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jamie.web.entity.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {
	
	@Query("SELECT j FROM Job j WHERE j.comMemId = :comMemId AND j.jobStatus = 1")
	List<Job> findJobsByComMemId(int comMemId);
	
	@Query("SELECT j FROM Job j WHERE j.comMemId = :comMemId AND j.jobNo = :jobNo")
    Job findJobName(int comMemId, int jobNo);

}
