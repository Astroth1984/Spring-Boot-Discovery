package com.docxcod.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docxcod.springboot.cruddemo.dao.EmployeeDAO;
import com.docxcod.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		List<Employee> employees = this.employeeDAO.findAll();
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return this.employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		this.employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		this.employeeDAO.deleteById(id);
	}

}
