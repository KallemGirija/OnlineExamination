package com.abc.trainingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.trainingapp.entity.Course;

public interface CourseRepository  extends JpaRepository<Course,Integer>{

}
