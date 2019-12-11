package com.example.springbootcrudapi.dao;

import java.util.List;

import com.example.springbootcrudapi.model.Employee;

public interface EmployeeDAO {
	List<Employee> get(); 
	Employee get(int id);  
	void save(Employee emp); 
	void delete(int id); 
	
	
}
