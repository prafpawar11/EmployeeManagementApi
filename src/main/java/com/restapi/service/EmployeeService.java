package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.pojo.Employee;
import com.restapi.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repos;

	public List<Employee> getAllEmployee() {
		return repos.findAll();
	}

	public Optional<Employee> getEmployee(int id) {

		Optional<Employee> emp = repos.findById(id);
		if (emp.isPresent()) {
			return emp;
		}

		return null;
	}

	public Employee createEmployee(Employee emp) {
		repos.save(emp);
		return emp;
	}

	public Employee updateEmployee(Employee emp) {

		return repos.save(emp);
	}
	
	public void deleteEmployee(int id)
	{
		repos.deleteById(id);
	}
	
	

}
