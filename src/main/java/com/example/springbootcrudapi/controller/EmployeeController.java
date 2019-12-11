package com.example.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmployeeService; 
	
	@GetMapping("/employee")
	public List<Employee> get(){
		
		return EmployeeService.get(); 
		
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee obj) {
		 EmployeeService.save(obj);
		 return obj; 
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		Employee employeeObj =  EmployeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("No entry found"); 
		}else {
			return employeeObj;
		}
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		EmployeeService.delete(id);
		return "removed with id- "+id; 
	}
	
}
	