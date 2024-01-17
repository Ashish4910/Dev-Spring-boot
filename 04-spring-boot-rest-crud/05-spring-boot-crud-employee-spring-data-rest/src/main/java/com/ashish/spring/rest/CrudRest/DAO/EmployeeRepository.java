package com.ashish.spring.rest.CrudRest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ashish.spring.rest.CrudRest.entity.Employee;

@RepositoryRestResource(path="members")
public interface EmployeeRepository  extends JpaRepository<Employee , Integer>{

}
