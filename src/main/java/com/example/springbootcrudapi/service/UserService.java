package com.example.springbootcrudapi.service;

import com.example.springbootcrudapi.model.User;

public interface UserService {
  	User get(String username, String password);
}
