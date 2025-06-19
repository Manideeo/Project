package com.example.ecomm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.User;
@Service
public class CourseService {
	@Autowired
	CourseDao courseDao;
	@Autowired
	UserDao userDao;
	
	@Autowired
	AssessmentDao assessmentDao;
	
	public Course saveCourse(Course course) {
		return courseDao.saveCourse(course);
	}
	
	public List<User> addI2c(long cid,long uid){
		
		User userdb=userDao.findUserById(uid);
		Course coursedb=courseDao.findCourseById(cid);
		
		List<User> ul=new ArrayList<User>();
		ul.add(userdb);
		coursedb.setUsers(ul);
		return courseDao.saveCourse(coursedb).getUsers();
		
	}
	
	public Course addA2C(long cid,long aid) {
		Assessment adb=assessmentDao.findAssessById(aid);
		Course coursedb=courseDao.findCourseById(cid);
		
		List<Assessment> al=coursedb.getAssessments();
		al.add(adb);
		
		System.out.println(al.get(0).getAssessmentID());
		
		coursedb.setAssessments(al);
		return courseDao.saveCourse(coursedb);
		
	}

}
