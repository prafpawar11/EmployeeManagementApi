package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/softtech")
@RequestMapping("/api/v2/")
public class SofttechController {

	@GetMapping(path = "/info")
	public String get() {
		// soft.count();
		return "Hello";
	}

	@GetMapping(path = "/course")
	public String getData() {
		return "API automation classes";
	}

}
