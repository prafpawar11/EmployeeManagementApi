package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.pojo.Customer;
import com.restapi.pojo.Employee;
import com.restapi.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repos;

	public List<Customer> getAllCustomers() {
		
		return repos.findAll();
	}

	public List<Customer> findAllCustomerUsingState(String state) {

		List<Customer> cust = repos.findAllCustomerUsingState(state);		
		return cust;
	}
	
	public Optional<Customer> getCustomer(int id) {

		Optional<Customer> cust = repos.findById(id);
		if (cust.isPresent()) {
			return cust;
		}

		return null;
	}

	public Customer createCustomer(Customer cust) {
		repos.save(cust);
		return cust;
	}

	public Customer updateCustomer(Customer cust) {

		return repos.save(cust);
	}

	public void deleteCustomer(int id) {
		repos.deleteById(id);
	}
}
