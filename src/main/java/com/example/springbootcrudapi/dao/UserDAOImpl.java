package com.example.springbootcrudapi.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springbootcrudapi.model.Employee;
import com.example.springbootcrudapi.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private EntityManager entitymanager; 
	
	@Override
	public User getUser(String username, String pasword) {
		// TODO Auto-generated method stub
		Session currentSession = entitymanager.unwrap(Session.class); 
		Query<User> query =  currentSession.createQuery("from User where username = :usernameParam and password= :passwordParam", User.class);
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", pasword); 
		try {
			return query.getSingleResult();			
		}catch(Exception e) {
			return new User("", ""); 
		}
	}

}
