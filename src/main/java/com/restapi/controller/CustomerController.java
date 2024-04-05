package com.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.View;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.restapi.pojo.Customer;
import com.restapi.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController

public class CustomerController {

	@Autowired
	CustomerService service;

	@Operation(summary = "User is on Customer Page")
	@GetMapping(path = "/hello")
	public ModelAndView home() {

		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		m.setViewName("customer");
		return m;
	}

	@Operation(summary = "Get All Customer Information")
	@GetMapping(path = "/customers", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> getAllCustomer() {

		try {
			List<Customer> allCustomer = service.getAllCustomers();

			if (allCustomer.isEmpty()) {
				return new ResponseEntity<>(allCustomer, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(allCustomer, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Operation(summary = "Get Customer Information by using Customer Id Number")
	@GetMapping(path = "/customers/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {

		try {
			return new ResponseEntity<>(service.getCustomer(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Get All Customer Information by using Customer State")
	@GetMapping(path = "/customer}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Customer>> getCustomerInfoUsingState(@RequestParam String state) {

		try {
			List<Customer> allCustomer = service.findAllCustomerUsingState(state);

			if (allCustomer.isEmpty()) {
				return new ResponseEntity<>(allCustomer, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<>(allCustomer, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Operation(summary = "Create New Customer")
	@PostMapping(path = "/customers", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Customer> createCustomera(@RequestBody Customer cust) {

		try {
			return new ResponseEntity<>(service.createCustomer(cust), HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "Update Customer Information by using Customer Id Number")
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

	@Operation(summary = "Delete Customer Information by using Customer Id Number")
	@DeleteMapping(path = "/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable int id) {
		try {
			service.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

}
