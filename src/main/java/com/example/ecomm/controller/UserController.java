package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.Enrollment;
import com.example.ecomm.dto.Submission;
import com.example.ecomm.dto.User;
import com.example.ecomm.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user ) {
		return service.saveUser(user);
	}
	
	@GetMapping("/login")
	public User login(@RequestBody User user) {
		return service.login(user.getEmail(),user.getPassword());
	}
	@PostMapping("/addc2s/{uid}/{cid}")
	public List<Enrollment> addCourseToStudent(@PathVariable long uid,@PathVariable long cid) {
		
		return service.addCourseToStudent(uid, cid).getEnrollments();
		
	}
	@DeleteMapping("deletecFromU/{uid}/{cid}")
	public List<Course> deletecFromU(@PathVariable long uid,@PathVariable long cid){
		return service.deletecFromU(uid, cid).getCourses();
	}
	
	@GetMapping("/userEnrollments/{uid}")
	public List<Enrollment> userEnrollments(@PathVariable long uid){
		return service.userEnrollments(uid);
	}
	
	@GetMapping("/getEnrolls/{uid}")
	public List<Enrollment> getEnrolls(@PathVariable int uid){
		return service.getEnrolls(uid);
	}
	
	@GetMapping("/getSubmissions/{uid}")
	public List<Submission> getSubmissions(@PathVariable int uid){
		return service.getSubmissions(uid);
	}
	
	 

}
