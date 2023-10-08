package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.pojo.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer>{

	
	
	
}
