package com.ashish.spring.rest.CrudDemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ashish.spring.rest.CrudDemo.entity.Course;
import com.ashish.spring.rest.CrudDemo.entity.Instructor;
import com.ashish.spring.rest.CrudDemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Course> findCourseByInstructorId(int theId) {

		TypedQuery<Course> course = entityManager.createQuery("from Course where instructor.id=:data", Course.class);

		course.setParameter("data", theId);

		List<Course> instructor = course.getResultList();

		return instructor;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {

		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " + "join Fetch i.course "
				+ "join fetch i.instructorDetail " + "where i.id=:data", Instructor.class);

		query.setParameter("data", theId);

		Instructor instructor = query.getSingleResult();

		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {

		entityManager.merge(tempInstructor);

	}

	@Override
	@Transactional
	public void update(Course tempCourse) {

		entityManager.merge(tempCourse);

	}

	@Override
	public Course findCourseById(int theId) {

		Course tempCourse = entityManager.find(Course.class, theId);

		return tempCourse;
	}

	@Override
	@Transactional
	public void deleteInstructor(int theId) {

		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		// get the course
		List<Course> course = tempInstructor.getCourse();

		// break the association of the course from Instructor

		for (Course tempCourse : course) {

			tempCourse.setInstructor(null);

		}

		// delete the Instructor
		entityManager.remove(tempInstructor);

	}

	@Override
	@Transactional
	public void deleteCourseById(int theid) {
		Course tempCourse = entityManager.find(Course.class, theid);
		
		entityManager.remove(tempCourse);
		
		
		
	}

}
