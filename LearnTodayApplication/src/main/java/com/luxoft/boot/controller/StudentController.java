package com.luxoft.boot.controller;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxoft.boot.model.CourseModel;
import com.luxoft.boot.model.StudentDeatailsModel;
import com.luxoft.boot.service.CourseService;
import com.luxoft.boot.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private CourseService courseService;


	@GetMapping("/getallSortedCourses")
	public ResponseEntity<List<CourseModel>> getAllSortedCourses() {
		List<CourseModel> listOfCourse = courseService.getAllCourses();
		listOfCourse.sort(Comparator.comparing(CourseModel::getStartDate));
		return new ResponseEntity<>(listOfCourse, HttpStatus.OK);
	}

	@PostMapping("/postStudent")
	public ResponseEntity<StudentDeatailsModel> postStudentDetails(@RequestBody StudentDeatailsModel student) {
		StudentDeatailsModel postStudents = studentService.postStudent(student);
		return new ResponseEntity<>(postStudents, HttpStatus.CREATED);

	}

	@DeleteMapping("deleteStudent/{enrollmentId}")
	public void deleteStudentEnrollmentById(@PathVariable("enrollmentId") Integer enrollmentId) {
	 studentService.deleteStudentEnrollment(enrollmentId);		

	}
	
}
