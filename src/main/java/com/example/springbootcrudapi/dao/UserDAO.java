package com.example.springbootcrudapi.dao;

import com.example.springbootcrudapi.model.User;

public interface UserDAO {

	User getUser(String username, String pasword); 
	
}
