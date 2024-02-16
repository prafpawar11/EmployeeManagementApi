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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.pojo.Customer;
import com.restapi.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v2/")
public class CustomerController {

	@Autowired
	CustomerService service;

	@Operation(summary = "User is on Customer Page")
	@GetMapping("/customer")
	public String home() {
		return "This is Customer Page";
	}

	@Operation(summary = "get All Customer Information")
	@GetMapping(path = "/customers")
	public ResponseEntity<List<Customer>> getAllCustomer() {

		try {
			List<Customer> allCustomer = service.getAllCustomers();

			if (allCustomer.isEmpty()) {
				return new ResponseEntity<>(allCustomer, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(allCustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "get Customer Information by using customer Id number")
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {

		Optional<Customer> cust1 = service.getCustomer(id);
		if (cust1.isPresent()) {
			Customer cust = cust1.get();
			return new ResponseEntity<>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "create new Customer")
	@PostMapping(path = "/customers", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Customer> createCustomera(@RequestBody Customer cust) {

		try {
			service.createCustomer(cust);

			return new ResponseEntity<>(cust, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "update Customer Information by using customer Id number")
	@PutMapping(path = "/customers/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer cust) {

		Optional<Customer> cust1 = service.getCustomer(id);

		if (cust1.isPresent()) {
			Customer Oldcust = cust1.get();
			Oldcust.setName(cust.getName());
			Oldcust.setGender(cust.getGender());
			Oldcust.setState(cust.getState());
			Oldcust.setCaddress(cust.getCaddress());

			service.updateCustomer(Oldcust);

			return new ResponseEntity<>(Oldcust, HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Operation(summary = "delete Customer Information by using customer Id number")
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id) {
		try {
			service.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

}
