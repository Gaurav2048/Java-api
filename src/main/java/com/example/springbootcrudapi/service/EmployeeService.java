package com.example.springbootcrudapi.service;

import java.util.List;

import com.example.springbootcrudapi.model.Employee;

public interface EmployeeService {
	List<Employee> get(); 
	Employee get(int id); 
	void save(Employee emp); 
	void delete(int id); 
}
