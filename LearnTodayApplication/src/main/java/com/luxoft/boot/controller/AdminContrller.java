package com.luxoft.boot.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.boot.entity.Course;
import com.luxoft.boot.model.CourseModel;
import com.luxoft.boot.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class AdminContrller {
	@Autowired
	private CourseService courseService;

	@PostMapping("/save")
	public ResponseEntity<Course> saveCourseDetails(@RequestBody CourseModel course) throws ParseException {
		Course save = courseService.saveCourse(course);
		return new ResponseEntity<Course>(save, HttpStatus.CREATED);
	}

		
	@GetMapping("/getAllCourse")
	public ResponseEntity<List<CourseModel>> getAllCourses() {
		List<CourseModel> listOfCourse = courseService.getAllCourses();
		return new ResponseEntity<>(listOfCourse, HttpStatus.OK);
	}

		@GetMapping("/getCourse/{courseId}")
		public ResponseEntity<CourseModel> getCourseById(@PathVariable("courseId") int courseId) {
			CourseModel courseById = courseService.getCourseById(courseId);
			return new ResponseEntity<>(courseById, HttpStatus.OK);

		}

}
