package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Submission;
import com.example.ecomm.service.SubmissionService;

@RestController
public class SubmissionController {
	
	@Autowired
	SubmissionService  service;
	
	@PostMapping("/submit/{uid}/{aid}")
	public Submission submit(@RequestBody Submission submission,@PathVariable long uid,@PathVariable long aid) {
		
		return service.saveSubmission(submission,uid,aid);
		
	}
	

}
