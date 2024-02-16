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

import com.restapi.pojo.Employee;
import com.restapi.pojo.Register;
import com.restapi.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v2/")
public class RegisterController {

	@Autowired
	RegisterService service;
	@Operation(summary = "register new user")
	@PostMapping(path = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Register> createUser(@RequestBody Register reg) {
		try {
			service.createUser(reg);

			return new ResponseEntity<>(reg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Register>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@Operation(summary = "get All user Information")
	@GetMapping(path = "/allusers")
	public ResponseEntity<List<Register>> getAllUsers() {
		try {
			List<Register> allusers = service.getAllUsers();

			return new ResponseEntity<>(allusers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Operation(summary = "get user Information by using user id number")
	@GetMapping(path = "/getuser/{id}")
	public ResponseEntity<Register> getUser(@PathVariable int id) {

		Optional<Register> user = service.getUser(id);

		if (user.isPresent()) {
			Register user1 = user.get();
			return new ResponseEntity<>(user1, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "update user Information by using user id number")
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<Register> updateUser(@PathVariable int id, @RequestBody Register reg) {

		Optional<Register> reg1 = service.getUser(id);
		if (reg1.isPresent()) {
			Register Oldreg = reg1.get();
			Oldreg.setName(reg.getName());
			Oldreg.setDept(reg.getDept());
			service.updateUser(Oldreg);
			return new ResponseEntity<>(Oldreg, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Operation(summary = "delete user Information by using user id number")
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
		try {
			service.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

	}

}
