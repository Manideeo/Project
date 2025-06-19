package com.example.ecomm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.SubmissionDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;

@Service
public class SubmissionService {
	
	@Autowired
	SubmissionDao submissionDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	AssessmentDao assessmentDao;
	
	public Submission saveSubmission(Submission submission,long uid,long aid) {
		
		User user=userDao.findUserById(uid);
		Assessment assessment=assessmentDao.findAssessById(aid);
		submission.setStudent(user);
		submission.setAssessment(assessment);
		
		return submissionDao.saveSubmission(submission);
	}
	
	public Submission findById(long sid) {
		 return submissionDao.findById(sid);
				
	}
}
