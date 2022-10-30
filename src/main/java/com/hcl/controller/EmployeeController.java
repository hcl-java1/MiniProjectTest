package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.domain.Employee;
import com.hcl.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
		return service.saveEmployees(employees);
	}

	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return service.getEmployees();
	}

	@GetMapping("/employeeById/{id}​​")
	public List<Employee> findEmployeeById(@PathVariable int id) {
		return service.getEmpById(id);
	}

//	@GetMapping("/employeeByName/{​​name}​​")
//	public List<Employee> findEmployeeById(@PathVariable String name) {
//		return service.getEmployeeByName(name);
//	}

//	@DeleteMapping("/delete/{​​id}​​")
//	public String deleteEmployee(@PathVariable int id) {
//		return service.deleteEmployee(id);
//	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);

	}

	@GetMapping("/employees/{city}/{dept}")
	public List<Employee> employeesByCityAndDept(@PathVariable String city, @PathVariable String dept) {
		return service.getEmployeesByCityAndDept(city, dept);
	}

	@GetMapping("/employees/{lastname}")
	public List<Employee> employeesByLastName(@PathVariable String lastname) {
		return service.getEmployeesByLastName(lastname);
	}

	@GetMapping("/search")
	public List<Employee> employeesById(@RequestParam String search) {
		return service.getEmployeeByIdOrName(search);
	}
}