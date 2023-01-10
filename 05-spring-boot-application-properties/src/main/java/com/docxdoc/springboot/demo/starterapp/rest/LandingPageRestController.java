package com.docxdoc.springboot.demo.starterapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingPageRestController {
	
	// Inject Application properties from File
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;

	@GetMapping("/")
	public String landingPageController() {
		return "Hello World. Time on Server is : " + LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run 100km";
	}
	
	@GetMapping("/teaminfo")
	public String getTeaminfo() {
		return "Coach name: "+ coachName + " and Team Name is "+ teamName;
	}
	
	
}
