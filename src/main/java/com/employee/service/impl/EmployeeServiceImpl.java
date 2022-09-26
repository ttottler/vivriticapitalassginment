package com.employee.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(int userId, String firstName) {
		Employee oldEmployee = employeeRepository.findById(userId);
		oldEmployee.setFirstName(firstName);
		return employeeRepository.save(oldEmployee);
	}

	@Override
	public void deleteEmployee(int userId) {
		employeeRepository.deleteById(userId);
	}

	@Override
	public List<Employee> listAllEmployees() {
		Iterable<Employee> iterator = employeeRepository.findAll();
		List<Employee> listEmployee = new ArrayList<>();
		while(iterator.iterator().hasNext()) {
			listEmployee.add(iterator.iterator().next());
		}
		return listEmployee;
	}
	
}
