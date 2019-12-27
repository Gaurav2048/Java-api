package com.example.springbootcrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootcrudapi.dao.UserDAO;
import com.example.springbootcrudapi.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO; 
	
	@Transactional
	@Override
	public User get(String username, String password) {
		// TODO Auto-generated method stub
		return	userDAO.getUser(username, password); 
		 
	}

}
