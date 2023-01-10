package com.codxdoc.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codxdoc.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Add method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
