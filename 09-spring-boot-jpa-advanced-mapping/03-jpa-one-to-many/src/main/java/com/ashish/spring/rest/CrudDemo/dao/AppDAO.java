package com.ashish.spring.rest.CrudDemo.dao;

import java.util.List;

import com.ashish.spring.rest.CrudDemo.entity.Course;
import com.ashish.spring.rest.CrudDemo.entity.Instructor;
import com.ashish.spring.rest.CrudDemo.entity.InstructorDetail;

public interface AppDAO {

	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	void delete(int theId);
	InstructorDetail findInstructorDetailById(int theId);
	void instructorDetailDeleteById(int theId);
	
	List<Course> findCourseByInstructorId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor tempInstructor);
	
	void update(Course tempCourse);
	
	Course findCourseById(int theId);
	
	 void deleteInstructor(int theId);
	 
	 void deleteCourseById(int theid);
}
