package com.example.springbootcrudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootcrudapi.model.Employee;

@Repository
public class EmployeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entitymanager; 
	
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		Session currentSession = entitymanager.unwrap(Session.class); 
		Query<Employee> query =  currentSession.createQuery("from Employee order by id asc", Employee.class); 
		return query.getResultList(); 
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entitymanager.unwrap(Session.class); 
		return currentSession.get(Employee.class, id);
	}

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		Session session = entitymanager.unwrap(Session.class); 
		 session.save(emp); 
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = entitymanager.unwrap(Session.class); 
		Employee em_one = session.get(Employee.class, id);
		session.delete(em_one);
		
	}

}
