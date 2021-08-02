package com.luv2codeinjava.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//Verbose => @RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String helloWorld() {
		return "Welcome to luv2codeinjava";
	}

}
