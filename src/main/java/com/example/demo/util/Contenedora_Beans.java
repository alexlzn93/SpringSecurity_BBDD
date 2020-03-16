package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Usuario;

@Configuration
public class Contenedora_Beans {
	@Bean
	public List<Usuario> getUser(){
		List<Usuario> usuarios=new ArrayList();
		Usuario u1=new Usuario(1,"juan","juan123");
		Usuario u2=new Usuario(2,"ana","ana123");
		Usuario u3=new Usuario(3,"luis","luis123");
		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
		return usuarios;
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}


}
