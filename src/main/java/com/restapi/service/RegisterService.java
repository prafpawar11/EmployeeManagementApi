package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.pojo.Employee;
import com.restapi.pojo.Register;
import com.restapi.repository.RegisterRepository;

@Service
public class RegisterService {

	@Autowired
	RegisterRepository repos;

	public Register createUser(Register reg) {
		repos.save(reg);
		return reg;

	}
	
	public Optional<Register> getUser(int id) {

		Optional<Register> reg = repos.findById(id);
		if (reg.isPresent()) {
			return reg;
		}

		return null;
	}

	public List<Register> getAllUsers()
	{
		return repos.findAll();
	}
	
	public Register updateUser(Register reg) {

		return repos.save(reg);
	}

	public void deleteUser(int id)
	{
		repos.deleteById(id);
	}

}
