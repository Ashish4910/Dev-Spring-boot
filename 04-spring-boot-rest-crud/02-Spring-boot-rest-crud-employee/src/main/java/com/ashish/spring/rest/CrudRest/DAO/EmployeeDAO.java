package com.ashish.spring.rest.CrudRest.DAO;

import java.util.List;

import com.ashish.spring.rest.CrudRest.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	Employee findBYId(int id);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
