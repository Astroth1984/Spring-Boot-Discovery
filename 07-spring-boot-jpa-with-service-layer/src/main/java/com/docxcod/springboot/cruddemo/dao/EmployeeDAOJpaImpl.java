package com.docxcod.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.docxcod.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Query query = this.entityManager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		
		// update with id from db ... so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
		/*
		 * Employee employee = findById(id);
		 * entityManager.remove(employee);
		 */
		
		// delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id =: emplId");
		query.setParameter("emplId", id);
		
		query.executeUpdate();

	}

}
