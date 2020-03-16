package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User1;



public interface IUserRepository extends CrudRepository<User1,String>{
   
}
