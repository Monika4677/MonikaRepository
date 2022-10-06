package com.luxoft.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxoft.boot.entity.StudentDeatails;

public interface StudentRepository extends JpaRepository<StudentDeatails, Integer>{

}
