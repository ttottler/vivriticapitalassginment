package com.employee.controller;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PatchMapping("/{user_id}")
	public Employee update(@PathVariable int user_id, @RequestParam String firstName) {
		return employeeService.updateEmployee(user_id, firstName);
	}
	
	@DeleteMapping
	public String delete(@RequestParam int userId) {
		employeeService.deleteEmployee(userId);
		return "User Deleted Successfully";
	}
	
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){
		return employeeService.listAllEmployees();
	}
	
	@GetMapping("/average")
	public double findAverage(@RequestBody List<Integer> listIntegers) {
		OptionalDouble average = listIntegers.stream().mapToInt(no -> no).average();
		return average.isPresent() ? average.getAsDouble() : 0;
	}
}
