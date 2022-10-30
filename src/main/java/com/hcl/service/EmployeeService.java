package com.hcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.repository.*;
import com.hcl.domain.*;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public Employee saveEmployee(Employee employee)

	{
		System.out.println(employee);

		return repository.save(employee);
	}

	public List<Employee> saveEmployees(List<Employee> employees) {

		return repository.saveAll(employees);
	}

	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public List<Employee> getEmpById(int id) {
		return repository.findAllById(id);
	}

	public List<Employee> getEmployeeByName(String ename) {
		return repository.findByEname(ename);
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee removed !! " + id;
	}

	public Employee updateEmployee(Employee employee) {

		repository.updateEmp(employee.getEname(), employee.getEmail(), employee.getAddress(), employee.getPhone(),
				employee.getDept(), employee.getEno());
		return employee;
	}

	public List<Employee> getEmployeesByCityAndDept(String city, String dept) {
		return repository.findByCityAndDept(city, dept);
	}

	public List<Employee> getEmployeesByLastName(String lastname) {
		return repository.findByLastName(lastname);
	}

	public List<Employee> getEmployeeAsc() {
		return repository.findAllByOrderByEnoAsc();
	}

	public List<Employee> getEmployeeByIdOrName(String search) {
		try {
			int id = Integer.parseInt(search);
			return (List<Employee>) repository.findAllById(id);
		} catch (Exception e) {
			return repository.findByEname(search);
		}
	}

}
