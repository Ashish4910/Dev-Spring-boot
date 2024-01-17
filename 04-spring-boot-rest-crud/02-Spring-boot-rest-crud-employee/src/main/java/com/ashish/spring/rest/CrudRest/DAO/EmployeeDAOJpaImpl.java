package com.ashish.spring.rest.CrudRest.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashish.spring.rest.CrudRest.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define field for entity manager

	private EntityManager entityManager;

	// set up constructor injection

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// creat the query
		TypedQuery<Employee> employee = entityManager.createQuery("From Employee", Employee.class);

		// execute the query and get Result Set

		List<Employee> theQuery = employee.getResultList();

		// return the result
		return theQuery;
	}

	@Override
	public Employee findBYId(int id) {
		Employee theEmployee = entityManager.find(Employee.class, id);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}

	@Override

	public void deleteById(int theId) {

		Employee tempEmployee = entityManager.find(Employee.class, theId);
		entityManager.remove(tempEmployee);
	}

}
