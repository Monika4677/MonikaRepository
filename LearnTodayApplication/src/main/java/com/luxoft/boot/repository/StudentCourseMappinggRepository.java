package com.luxoft.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luxoft.boot.entity.StudentCourseMappingg;
import com.luxoft.boot.entity.StudentDeatails;

@Repository
public interface StudentCourseMappinggRepository extends JpaRepository<StudentCourseMappingg, Integer>{
 	StudentCourseMappingg findByStudent(StudentDeatails student);
}
