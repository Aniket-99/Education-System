package com.training.educationsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.educationsystem.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

	Course findByCourseName(String name);
}
