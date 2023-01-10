package com.docxcod.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docxcod.springboot.cruddemo.dao.EmployeeRepository;
import com.docxcod.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = this.employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result = this.employeeRepo.findById(id);
		
		Employee myEmpl = null;
		
		if(result.isPresent()) {
			myEmpl = result.get();
		} else {
			throw new RuntimeException("Did not find Employee id -" + id);
		}
		
		return myEmpl;
	}

	@Override
	public void save(Employee employee) {
		this.employeeRepo.save(employee);
	}

	@Override
	public void deleteById(int id) {
		this.employeeRepo.deleteById(id);
	}

}
