package com.practice2308.demo.dao;

import org.springframework.stereotype.Repository;

import com.practice2308.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImplement implements StudentDAO {

	private EntityManager entityManager;
	
	public StudentDAOImplement(EntityManager theentityManager)
	{
		entityManager = theentityManager;
	}
	@Override
	@Transactional
	public void ashish(Student theStudent) {
		entityManager.persist(theStudent);
	}

}
