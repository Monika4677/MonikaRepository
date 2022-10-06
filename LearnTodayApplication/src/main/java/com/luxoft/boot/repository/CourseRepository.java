package com.luxoft.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxoft.boot.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
