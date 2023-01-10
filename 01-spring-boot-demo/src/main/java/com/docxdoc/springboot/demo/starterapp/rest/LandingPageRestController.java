package com.docxdoc.springboot.demo.starterapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageRestController {

	@GetMapping("/")
	public String landingPageController() {
		return "Hello World. Time on Server is : " + LocalDateTime.now();
	}
}
