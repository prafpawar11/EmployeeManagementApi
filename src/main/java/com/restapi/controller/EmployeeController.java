package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.pojo.Employee;
import com.restapi.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@GetMapping
	public String home() {
		return "This is Home Page";
	}

	@GetMapping(path = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		try {
			List<Employee> allEmployee = service.getAllEmployee();

			if (allEmployee.isEmpty()) {
				return new ResponseEntity<>(allEmployee, HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(allEmployee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path="/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

		Optional<Employee> emp1 = service.getEmployee(id);
		if (emp1.isPresent()) {
			Employee emp = emp1.get();
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path="/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {

		try {
			service.createEmployee(emp);

			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {

		Optional<Employee> emp1 = service.getEmployee(id);

		if (emp1.isPresent()) {
			Employee Oldemp = emp1.get();
			Oldemp.setFirstname(emp.getFirstname());
			Oldemp.setLastname(emp.getLastname());
			Oldemp.setAddress(emp.getAddress());
			Oldemp.setEmailId(emp.getEmailId());
			Oldemp.setMobilenumber(emp.getMobilenumber());
			service.updateEmployee(Oldemp);

			return new ResponseEntity<>(Oldemp, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable int id) {
		try {
			service.deleteEmployee(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

}
