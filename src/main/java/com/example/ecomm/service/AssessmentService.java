package com.example.ecomm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dto.Assessment;

@Service
public class AssessmentService {
	
	@Autowired
	AssessmentDao assessmentDao;
	
	public Assessment save(Assessment assessment) {
		return assessmentDao.saveAssessment(assessment);
	}
}
