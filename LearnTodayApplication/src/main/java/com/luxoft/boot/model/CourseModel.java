package com.luxoft.boot.model;

import java.util.Date;

import lombok.Data;

@Data
public class CourseModel {
	private int courseId;

	private String tittle;

	private float fee;

	private String description;

	private String trainer;

	private Date startDate;
	
	

}
