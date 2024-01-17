package com.ashish.spring.rest.CrudDemo.dao;

import com.ashish.spring.rest.CrudDemo.entity.Instructor;
import com.ashish.spring.rest.CrudDemo.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	void delete(int theId);
	InstructorDetail findInstructorDetailById(int theId);
	void instructorDetailDeleteById(int theId);
}
