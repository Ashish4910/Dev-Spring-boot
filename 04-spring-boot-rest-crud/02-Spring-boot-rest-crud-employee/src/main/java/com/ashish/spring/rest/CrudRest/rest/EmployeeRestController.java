package com.ashish.spring.rest.CrudRest.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.spring.rest.CrudRest.Service.EmployeeService;
import com.ashish.spring.rest.CrudRest.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

// quick and dirty : inject employee dao using constructor injection

	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}

	// expose employee and return a list of employee

	@GetMapping("/employee")
	public List<Employee> findAll() {

		return employeeService.findAll();

	}

// find the data using id 
	@GetMapping("/employee/{id}")
	public Employee findBYIT(@PathVariable int id) {

		Employee theEmployee = employeeService.findBYId(id);
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not Found -= " + id);
		}
		return theEmployee;

	}

	// save the in db

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in some case they pass an id in Json set id to 0

		// this is to force a save of new item .. instead as update

		theEmployee.setId(0);

		Employee dbEmployee = employeeService.save(theEmployee);

		return dbEmployee;

	}

	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		Employee saveEmployee = employeeService.save(theEmployee);

		// dont need to call the theEmployee.set method because we need to update not
		// need to add employee

		return saveEmployee;

	}

//	@DeleteMapping("/employee/{id}")
//	public String deleteEmployee(@PathVariable int id) {
//
//		Employee tempEmployee = employeeService.findBYId(id);
//
//		// throw exception if id is null
//		if (tempEmployee == null) {
//			throw new RuntimeException("ID Did not found" + id);
//		}
//
//		employeeService.deleteById(id);
//		return "Deleted value -" + id;
//
//	}

//	@DeleteMapping("/employee/{employeeId}")
//	public String deleteEmployee(@PathVariable int employeeId) {
//
//		Employee tempEmployee = employeeService.findBYId(employeeId);
//		// throw exception if id is null
//		if (tempEmployee == null) {
//			throw new RuntimeException("ID Did not found" + employeeId);
//		}
//		employeeService.deleteById(employeeId);
//		return "Deleted  id is = " ;
//
//	}

	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable Integer employeeId) {

		// Employee tempEmployee = employeeService.findBYId(employeeId);

		// throw exception if null

		/*
		 * if (tempEmployee == null) { throw new
		 * RuntimeException("Employee id not found - " + employeeId); }
		 */
		employeeService.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}
}
