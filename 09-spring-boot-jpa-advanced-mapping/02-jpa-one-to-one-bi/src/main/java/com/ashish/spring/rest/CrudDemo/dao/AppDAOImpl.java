package com.ashish.spring.rest.CrudDemo.dao;

import org.springframework.stereotype.Repository;

import com.ashish.spring.rest.CrudDemo.entity.Instructor;
import com.ashish.spring.rest.CrudDemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TableGenerator;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	// define the Entity Manager
	public EntityManager entityManager;

	// inject the entity Manager for AutoWired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {

		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {

		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void delete(int theId) {

		// retrive the details using theId
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		// delete the retrive data using entityManager
		entityManager.remove(tempInstructor);

	}

	@Override
	@Transactional
	public InstructorDetail findInstructorDetailById(int theId) {

		// retrive the data using id

		InstructorDetail tempInstructor = entityManager.find(InstructorDetail.class, theId);

		return tempInstructor;

	}

	@Override
	@Transactional
	public void instructorDetailDeleteById(int theId) {

		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);

		instructorDetail.getInstructor().setInstructorDetail(null);

		entityManager.remove(instructorDetail);

	}

}
