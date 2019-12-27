package com.example.springbootcrudapi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.model.User;
import com.example.springbootcrudapi.service.EmployeeService;

//@RestController
//@RequestMapping("/api")
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService EmployeeService; 
	
	
	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView get(HttpSession session) {
		if(session.getAttribute("login_session")!=null) {
		ModelAndView mv = new ModelAndView("employeesList"); 
		mv.addObject("emp", EmployeeService.get());  
		return mv; 
		}else {
			ModelAndView mv = new ModelAndView("redirect:/operate"); 
			mv.addObject("user", new User("",""));  
			return mv; 
		}
		
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("login_session");;
		System.out.print("Reached here");
		ModelAndView modelAndView = new ModelAndView("redirect:/operate"); 
		return modelAndView;
	}
	
	
	
	
	
	@RequestMapping("/showEmployeeForm")
	public ModelAndView showEmployeeForm() {
		ModelAndView mv = new ModelAndView("employeesAdd");
		mv.addObject("employee", new Employee());
		return mv; 
	}
	
	
	//@PostMapping("/employee")
	@RequestMapping("/save")
	public ModelAndView save(@ModelAttribute("employee") Employee obj, Session session) {
		ModelAndView mv = new ModelAndView("redirect:/home");
		System.out.print(obj.getId()+" ");
		EmployeeService.save(obj);
		System.out.print(obj.getId()+" ");
		mv.addObject("emp", EmployeeService.get());  	
		return mv;
		
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.GET)
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
	