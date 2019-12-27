package com.example.springbootcrudapi.controller;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootcrudapi.model.User;
import com.example.springbootcrudapi.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService; 
	
	@RequestMapping(value= {"/operate"}, method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute User user, HttpSession session) {
		
		User user1 = userService.get(user.getUsername(), user.getPassword()); 
		
		if(user1.getUsername().equals("")) {
			ModelAndView mv = new ModelAndView("login"); 
			mv.addObject("error", "user id or password is not found"); 
			return mv; 
		}
		
		ModelAndView mv = new ModelAndView("redirect:/home"); 
		session.setAttribute("login_session", "active");
		return mv; 
		
	}
	
	
	@GetMapping(value= {"/operate"})
	public ModelAndView operate() {
		ModelAndView mv = new ModelAndView("login"); 
		mv.addObject("user", new User("",""));  
		return mv; 
		
	}
	
}
