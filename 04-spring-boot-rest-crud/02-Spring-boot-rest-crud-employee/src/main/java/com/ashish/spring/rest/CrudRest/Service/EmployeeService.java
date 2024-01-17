package com.ashish.spring.rest.CrudRest.Service;

import java.util.List;

import com.ashish.spring.rest.CrudRest.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findBYId(int id);

	Employee save(Employee theEmployee);

	// void deleteById(int theId);

	void deleteById(int id);
}
