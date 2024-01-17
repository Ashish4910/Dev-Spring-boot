package com.ashish.spring.rest.CrudDemo.dao;

import com.ashish.spring.rest.CrudDemo.entity.Instructor;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	void delete(int theId);
}
