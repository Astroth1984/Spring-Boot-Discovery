package com.docxcod.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docxcod.springboot.cruddemo.entity.Employee;
import com.docxcod.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return this.employeeService.findAll();
	}
	
	@GetMapping("/employees/{emplId}")
	public Employee getEmployee(@PathVariable int emplId) {
		Employee empl = this.employeeService.findById(emplId);
		
		if(empl == null ) {
			throw new RuntimeException("Employee id not found - " + emplId);
		}
		 
		return empl;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		employeeService.save(employee);
		return employee;
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/employees/{emplId}")
	public String deleteEmployee(@PathVariable int emplId) {
		
		Employee theEmpl = employeeService.findById(emplId);
		
		// If null throw an Exception
		if(theEmpl == null) {
			throw new RuntimeException("Employee id not found - " + emplId);
		}
		
		employeeService.deleteById(emplId);
		
		return "Deleted Employee id - " + emplId;
	}
}

