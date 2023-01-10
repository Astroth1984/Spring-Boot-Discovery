package com.codxdoc.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codxdoc.springboot.thymeleafdemo.entity.Employee;
import com.codxdoc.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private EmployeeService emplService;
	
	public EmployeeController(EmployeeService emplService) {
		this.emplService = emplService;
	}
	
	
	// Mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model listModel) {
		
		List<Employee> employees = this.emplService.findAll();
		
		listModel.addAttribute("employees", employees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// Create the Model Attribute to bind form data
		Employee theEmpl = new Employee();
		theModel.addAttribute("employee", theEmpl);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int empId, Model theModel) {
		
		// Get Employee from service
		Employee theEmployee = this.emplService.findById(empId);
		
		// set employee as a model attribute to pre-populate form
		theModel.addAttribute("employee", theEmployee);
		// send over to form
		
		return "employees/employee-form";
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmpl) {
		
		// save the Empl to DB
		this.emplService.save(theEmpl);
		
		// Use redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int emplId) {
		
		// delete Employee
		this.emplService.deleteById(emplId);
		
		// Redirect
		return "redirect:/employees/list";
	}

}
