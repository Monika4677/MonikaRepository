
package com.luxoft.boot.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data

@Table(name = "studentCourseMapping")
public class StudentCourseMappingg {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer enrollmentId;

	@OneToOne
    @JoinColumn(name = "studentId") 
	private StudentDeatails student;
	@OneToOne
    @JoinColumn(name = "courseId") 
	private Course course;

}
