package com.abc.trainingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.abc.trainingapp.entity.Instructor;


@Repository
public interface InstructorRepository extends 
        JpaRepository<Instructor,Integer>,CustomInstructorRepository
{



}