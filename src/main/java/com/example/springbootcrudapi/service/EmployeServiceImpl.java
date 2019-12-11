package com.example.springbootcrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcrudapi.dao.EmployeDAOImpl;
import com.example.springbootcrudapi.dao.EmployeeDAO;
import com.example.springbootcrudapi.model.Employee;

@Service
public class EmployeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeDAO; 
	
	@Transactional
	@Override
	public List<Employee> get() {
		// TODO Auto-generated method stub
		return employeDAO.get(); 
	}

	@Transactional
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return employeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		 employeDAO.save(emp);
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeDAO.delete(id);
	}

}
