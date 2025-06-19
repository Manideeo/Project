package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Assessment;
import com.example.ecomm.service.AssessmentService;

@RestController
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	@PostMapping("saveAssess")
	public Assessment saveAssessment(@RequestBody Assessment assessment) {
		return assessmentService.save(assessment);
	}
}
