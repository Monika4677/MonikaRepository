package com.luxoft.boot.service;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxoft.boot.entity.Course;
import com.luxoft.boot.exception.ResourceNotFound;
import com.luxoft.boot.model.CourseModel;
import com.luxoft.boot.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(CourseModel courseModel) throws ParseException {	
		Course save = null;
		Course course = new Course();
				BeanUtils.copyProperties(courseModel, course);
				course.setStartDate((java.sql.Date) new Date());
				save = courseRepository.save(course);
		return save;
	}

	
	@Override
	public List<CourseModel> getAllCourses() {
		List<CourseModel> listOfModel = new ArrayList<>();

		List<Course> listOfCourses = courseRepository.findAll();
		if (null == listOfCourses || listOfCourses.isEmpty()) {
			throw new ResourceNotFound("Courses are not avilable");
		}
		listOfCourses.forEach(n -> {
			CourseModel courseModel = new CourseModel();
			BeanUtils.copyProperties(n, courseModel);
			listOfModel.add(courseModel);

		});

		return listOfModel;
	}

	@Override
	public CourseModel getCourseById(int courseId) {
		CourseModel courseModel=new CourseModel();
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFound("Searched Data not Found"));
		BeanUtils.copyProperties(course, courseModel);
		return courseModel;
	}

}
