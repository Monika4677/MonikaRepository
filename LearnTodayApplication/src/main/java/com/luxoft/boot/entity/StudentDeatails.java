package com.luxoft.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "studentDetails")
public class StudentDeatails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;

	@Column(name = "student_Name")
	private String studentName;

	@Column(name = "mobile_No")
	private Integer mobileNo;

	@Column(name = "email")
	private String email;
}
