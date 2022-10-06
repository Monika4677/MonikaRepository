package com.luxoft.boot.model;

import lombok.Data;

@Data

public class StudentDeatailsModel {

	private Integer studentId;
	private String studentName;
	private Integer mobileNo;
	private String email;
	private SelectedCourseModel selectedCourse;
	
}
