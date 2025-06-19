package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecomm.dao.CourseDao;
import com.example.ecomm.dao.EnrollmentDao;
import com.example.ecomm.dao.UserDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Enrollment;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;
import com.example.ecomm.repository.EnrollementRepository;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	EnrollmentDao enrollmentDao;
	
	 
	
	public User saveUser(User user) {
		return dao.saveUser(user);
	}
	
	public User login(String email,String password) {
		return dao.login(email,password);
	}
	
//	public User addCourseToStudent(long userId,long cid) {
//		User userdb= dao.findUserById(userId);
//		Course coursedb=courseDao.findCourseById(cid);
//		List<Course> courses=  userdb.getCourses();
//		if(!courses.contains(coursedb)) {
//			courses.add(coursedb);
//		}
//		userdb.setCourses(courses);
//		
//		
//		return dao.saveUser(userdb);
//	}
	
	
	public User addCourseToStudent(long userId,long cid) {
		User userdb= dao.findUserById(userId);
		Course coursedb=courseDao.findCourseById(cid);
		//List<Course> courses=  userdb.getCourses();
		List<Enrollment> enrls=userdb.getEnrollments();
		Enrollment enrollment=new Enrollment();
		enrollment.setCourse(coursedb);
		enrollment.setStudent(userdb);
		enrollment.setProgress(0);
		
		enrls.add(enrollment);
		
		return dao.saveUser(userdb);
	}
	
	public User deletecFromU( long uid, long cid){
		User userdb= dao.findUserById(uid);
		Course coursedb=courseDao.findCourseById(cid);
		List<Course> courses=  userdb.getCourses();
		courses.remove(coursedb);
		return dao.saveUser(userdb);
		
	}
	
	public List<Enrollment> userEnrollments(long uid){
		User userdb=dao.findUserById(uid);
		if(userdb!=null) {
			List<Enrollment> list=userdb.getEnrollments();
			return list;
		}
		return null;
	}
	
	public List<Enrollment> getEnrolls(int uid){
		User user=dao.findUserById(uid);
		return user.getEnrollments();
	}
	
	@GetMapping("/getSubmissions/{sid}")
	public List<Submission> getSubmissions(@PathVariable int uid){
		User user=dao.findUserById(uid);
		return user.getSubmissions();
	}
	
	 

}
