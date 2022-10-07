package com.luxoft.boot.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.luxoft.boot.entity.Course;
import com.luxoft.boot.entity.StudentCourseMappingg;
import com.luxoft.boot.entity.StudentDeatails;
import com.luxoft.boot.exception.ResourceNotFound;
import com.luxoft.boot.exception.StudentEnrollmentNotFoundException;
import com.luxoft.boot.model.SelectedCourseModel;
import com.luxoft.boot.model.StudentDeatailsModel;
import com.luxoft.boot.repository.CourseRepository;
import com.luxoft.boot.repository.StudentCourseMappinggRepository;
import com.luxoft.boot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository ;
	@Autowired
	private CourseRepository courseRepository ;
	@Autowired
	private StudentCourseMappinggRepository studentCourseMappinggRepository;

	@Override
	public StudentDeatailsModel postStudent(StudentDeatailsModel student) {
		
		 StudentDeatailsModel studentDetailsModel=new StudentDeatailsModel();
		StudentDeatails studentDetail=new StudentDeatails();
		BeanUtils.copyProperties(student, studentDetail);
		try {
		StudentDeatails savedStudent=studentRepository.save(studentDetail);
		Optional<Course> course=courseRepository.findById(student.getSelectedCourse().getCourseId());
		if(course.isPresent()) {
			StudentCourseMappingg studentCourseMap=new StudentCourseMappingg();
			studentCourseMap.setCourse(course.get());
			studentCourseMap.setStudent(savedStudent);
			 StudentCourseMappingg savedCourseMap=studentCourseMappinggRepository.save(studentCourseMap);
		
				BeanUtils.copyProperties(savedStudent,studentDetailsModel);
				SelectedCourseModel modelselected=new SelectedCourseModel();
				modelselected.setCourseId(savedCourseMap.getCourse().getCourseId());
				modelselected.setCourseName(savedCourseMap.getCourse().getTittle());
				studentDetailsModel.setSelectedCourse(modelselected);
		}
		}catch (Exception e) {
		
		}
			
		return studentDetailsModel;
	}

	@Override
	public void deleteStudentEnrollment(Integer enrollmentId) {
		StudentDeatails student = studentRepository.findById(enrollmentId)
				.orElseThrow(() -> new StudentEnrollmentNotFoundException(
						" Student enrollmentNotFoundException with the enrollmentId " + enrollmentId));
		StudentCourseMappingg mapping = studentCourseMappinggRepository.findByStudent(student);
		studentCourseMappinggRepository.delete(mapping);
		studentRepository.delete(student);

	}
}
