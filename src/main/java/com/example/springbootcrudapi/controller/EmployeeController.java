package com.example.springbootcrudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.service.EmployeeService;

//@RestController
//@RequestMapping("/api")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmployeeService; 
	
	
	
	
	
//	@GetMapping("/employee")
//	public List<Employee> get(){
//		return EmployeeService.get(); 
//	}

	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView get() {
		
		ModelAndView mv = new ModelAndView("employeesList"); 
		mv.addObject("emp", EmployeeService.get());  
		return mv; 
		
	}
	
	
	@RequestMapping("/showEmployeeForm")
	public ModelAndView showEmployeeForm() {
		ModelAndView mv = new ModelAndView("employeesAdd");
		mv.addObject("employee", new Employee());
		return mv; 
	}
	
	
	//@PostMapping("/employee")
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") Employee obj) {
		ModelAndView mv = new ModelAndView("employeesList");
		EmployeeService.save(obj);
		mv.addObject("emp", EmployeeService.get());  	
		return mv;
		
	}
	
	@RequestMapping("/employee")
	public ModelAndView get(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView("employeesAdd");
		Employee employeeObj =  EmployeeService.get(id);
		mv.addObject("employee", employeeObj); 
		return mv; 
	}
	
	//@DeleteMapping("/employee/{id}")
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		EmployeeService.delete(id);
		ModelAndView mav = new ModelAndView("employeesList"); 
		mav.addObject("emp", EmployeeService.get());  
		return mav; 
	}
	
}
	