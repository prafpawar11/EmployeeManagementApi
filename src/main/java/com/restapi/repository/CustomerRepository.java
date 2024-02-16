package com.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restapi.pojo.Customer;
import com.restapi.pojo.Employee;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	
	@Query("from Customer where state in ?1")
	List<Customer> findAllCustomerUsingState(String state);

}
