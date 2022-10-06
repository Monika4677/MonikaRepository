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
@Table(name = "trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainerId;
	@Column(name = "trainer_name", nullable = false)
	private String trainerName;
	@Column(name = "email", nullable = false)
	private String email;	
	@Column(name = "password", nullable = false)
	private String password;
	
}
