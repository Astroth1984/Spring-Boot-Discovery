package com.codxdoc.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codxdoc.springboot.thymeleafdemo.model.Employee;

import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private List<Employee> theEmployees;
	
	@PostConstruct
	private void loadData() {
		
		// Create Employees
		Employee empl1 = new Employee(1, "Leslie","Andrews", "leslie2@codxdoc.com");
		Employee empl2 = new Employee(2, "Thome","Andresons", "thomsandrs@codxdoc.com");
		Employee empl3 = new Employee(3, "Morphius","Neo", "neom0rp4eu3@codxdoc.com");
		
		// Create List and load list of employees
		this.theEmployees = new ArrayList<>();
		
		this.theEmployees.add(empl1);
		this.theEmployees.add(empl2);
		this.theEmployees.add(empl3);
	}
	
	// Mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model listModel) {
		
		listModel.addAttribute("employees", this.theEmployees);
		
		return "list-employees";
	}

}
