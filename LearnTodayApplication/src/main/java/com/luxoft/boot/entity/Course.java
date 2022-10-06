package com.luxoft.boot.entity;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	@Column(name="tittle",nullable = false)
	private String tittle;
	@Column(name="fee")
	private float fee;
	@Column(name="description")
	private String description;		   
	private String trainer;
	@Column(name="startDate")
    private Date startDate;

}
