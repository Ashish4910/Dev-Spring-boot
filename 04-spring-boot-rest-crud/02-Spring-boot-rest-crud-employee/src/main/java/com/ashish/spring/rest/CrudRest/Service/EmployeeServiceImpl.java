package com.ashish.spring.rest.CrudRest.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashish.spring.rest.CrudRest.DAO.EmployeeDAO;
import com.ashish.spring.rest.CrudRest.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	// inject the EmployeeDAO using constructor
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;

	}

	@Override
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	@Override
	public Employee findBYId(int id) {

		return employeeDAO.findBYId(id);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {

		return employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);

	}

}
