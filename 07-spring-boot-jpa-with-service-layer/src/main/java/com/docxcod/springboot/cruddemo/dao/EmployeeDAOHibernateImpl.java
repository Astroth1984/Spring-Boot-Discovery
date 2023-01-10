package com.docxcod.springboot.cruddemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.docxcod.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	// Define Field for EntityManager
	private EntityManager entityManager;
	
	// set up Constructor Injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		// Get Current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		// execute query and get result List
		List<Employee> employees = query.getResultList();
		
		// return the result
		return employees;
	}

	@Override
	public Employee findById(int id) {
		
		// Get Current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// Get the Imployee
		Employee employee = currentSession.get(Employee.class, id);
		
		return employee;
	}

	
	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(employee);	
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where id=: empId", Employee.class);
		query.setParameter("empId", id);
		query.executeUpdate();
	}
	
}
