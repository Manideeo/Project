package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.dao.AssessmentDao;
import com.example.ecomm.dto.Assessment;
import com.example.ecomm.dto.Course;
import com.example.ecomm.dto.User;
import com.example.ecomm.service.CourseService;
@RestController
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	
	
	@PostMapping("/saveCourse")
	public Course saveCourse(@RequestBody Course course) {
		Course course2=courseService.saveCourse(course);
		 return  course2;
		
	}
	@GetMapping("/addi2c/{cid}/{uid}")
	public List<User> addI2c(@PathVariable long cid,@PathVariable long uid){
		return courseService.addI2c(cid, uid);
	}
	
	@PostMapping("/addA2c/{cid}/{aid}")
	public Course addA2c(@PathVariable long cid,@PathVariable long aid){
		Course course=courseService.addA2C(cid, aid);
		return course;
		
		
	}
	

}
