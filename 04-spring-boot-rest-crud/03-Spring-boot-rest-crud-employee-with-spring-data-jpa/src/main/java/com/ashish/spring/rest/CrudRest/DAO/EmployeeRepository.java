package com.ashish.spring.rest.CrudRest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.spring.rest.CrudRest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	

}
