package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.pojo.Employee;
import com.restapi.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v2/")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	static Employee Oldemp;
	
	@Operation(summary = "get All Employee Information")
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

	@Operation(summary = "get Employee Information by using Employee Id number")
	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

		Optional<Employee> emp1 = service.getEmployee(id);
		if (emp1.isPresent()) {
			return new ResponseEntity<>(emp1.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "get All Employee Information by using Employee firstName")
	@GetMapping(path = "/employee")
	public ResponseEntity<List<Employee>> getEmployeeInfoUsingFirstName(@RequestParam String firstname) {

		try {
			List<Employee> allEmployee = service.getEmployeeUsingFirstName(firstname);

			if (allEmployee.isEmpty()) {
				return new ResponseEntity<>(allEmployee, HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(allEmployee, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "create a new Employee")
	@PostMapping(path = "/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {

		try {
			service.createEmployee(emp);

			return new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "update Employee Information by using Employee Id number")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {

		Optional<Employee> emp1 = service.getEmployee(id);

		if (emp1.isPresent()) {
			Oldemp = emp1.get();
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

	@Operation(summary = "update Employee Information by using Employee Id number")
	@PatchMapping("/employees/{id}")
	public ResponseEntity<Employee> updateSpecificEmployee(@PathVariable int id, @RequestBody Employee emp) {

		Optional<Employee> emp1 = service.getEmployee(id);
		
		if (emp1.isPresent()) 
		{
			Oldemp = emp1.get();

			if (emp.getFirstname() != null) {
				Oldemp.setFirstname(emp.getFirstname());
			}
			if (emp.getLastname() != null) {
				Oldemp.setLastname(emp.getLastname());
			}
			if (emp.getAddress() != null) {
				Oldemp.setAddress(emp.getAddress());
			}
			if (emp.getEmailId() != null) {
				Oldemp.setEmailId(emp.getEmailId());
			}
			if (emp.getMobilenumber() != null) {
				Oldemp.setMobilenumber(emp.getMobilenumber());
			}

			service.updateEmployee(Oldemp);

			return new ResponseEntity<>(Oldemp, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Operation(summary = "delete Employee Information by using Employee Id number")
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
