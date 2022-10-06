package com.luxoft.boot.service;



import com.luxoft.boot.model.StudentDeatailsModel;

public interface StudentService {
	
public StudentDeatailsModel postStudent(StudentDeatailsModel student);

 public void deleteStudentEnrollment (Integer enrollmentId); 
	
}
