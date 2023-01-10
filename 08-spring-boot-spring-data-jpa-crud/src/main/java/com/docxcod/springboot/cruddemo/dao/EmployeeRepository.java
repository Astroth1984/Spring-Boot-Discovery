package com.docxcod.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docxcod.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
