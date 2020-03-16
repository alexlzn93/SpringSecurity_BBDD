package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserRepository;
import com.example.demo.interfaces.IUserSERVICE;
import com.example.demo.model.User1;

@Service
public class UserSERVICE implements IUserSERVICE {
     @Autowired 
	 IUserRepository userrepository;

	@Override
	public void add_user(User1 user1) {
		userrepository.save(user1);
		
	}

	@Override
	public User1 find_by_user(String user) {
		
		return userrepository.findById(user).get();
	}
     
     
}
