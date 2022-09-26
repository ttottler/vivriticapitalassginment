package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public Employee updateEmployee(int userId, String firstName);
	
	public void deleteEmployee(int userId);
	
	public List<Employee> listAllEmployees();
	
}
