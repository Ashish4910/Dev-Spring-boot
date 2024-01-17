package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entitymanager;

	@Autowired
	public StudentDAOImpl(EntityManager theEntitymanager) {
		entitymanager = theEntitymanager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {
		entitymanager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {

		return entitymanager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery theQuery = entitymanager.createQuery("from Student", Student.class);

		return theQuery.getResultList();
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) {
		TypedQuery theQuery = entitymanager.createQuery("from Student where lastName=:theData", Student.class);
		theQuery.setParameter("theData", lastName);

		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entitymanager.merge(theStudent);

	}

	@Override
	@Transactional
	public void delete(Integer id) {

		Student myStudent = entitymanager.find(Student.class, id);
		entitymanager.remove(myStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numberofRowDeleted = entitymanager.createQuery("Delete from Student").executeUpdate();

		return numberofRowDeleted;
	}

}
