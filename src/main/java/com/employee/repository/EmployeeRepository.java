package com.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Employee findById(int userId);
	
}
