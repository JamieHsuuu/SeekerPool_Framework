package com.jamie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jamie.web.dao.JobRepository;
import com.jamie.web.entity.Job;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobRepository jobRepository;
	
	@GetMapping("/interviewInvite")
	public List<Job> findJobsByComMemId(@SessionAttribute("companyMember") int comMemId) {
		return jobRepository.findJobsByComMemId(comMemId);
	}

}
