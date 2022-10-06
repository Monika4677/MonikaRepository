package com.luxoft.boot.service;

import java.text.ParseException;
import java.util.List;

import com.luxoft.boot.entity.Course;
import com.luxoft.boot.model.CourseModel;

public interface CourseService {

	public Course saveCourse(CourseModel course) throws ParseException;
	
	public List<CourseModel> getAllCourses();
	
	public CourseModel getCourseById(int courseId);

}
