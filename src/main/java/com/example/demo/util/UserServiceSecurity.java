package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IUserSERVICE;
import com.example.demo.model.User1;
@Service
public class UserServiceSecurity implements UserDetailsService{
	@Autowired
	BCryptPasswordEncoder bycript;
	@Autowired
	IUserSERVICE userService;
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		System.out.println(usuario);
		User1 user1=userService.find_by_user(usuario);
//      User myuser=userrepository.findbynombre(usuario)
// los roles los meto a pelo deberian de estar en una bbdd		
	    List<GrantedAuthority> roles=new ArrayList();
	    // Set<Role> roles_user=myuser.getRoles();
	    // for {roles_user
	    //    roles.add(new SimpleGrantedAuthority(roles_user.getRole()));
	    //}
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		System.out.println(user1.getUser()+" "+user1.getPassword());
		UserDetails userDet=new User(user1.getUser(),user1.getPassword(),roles);
		//UserDetails userDet=new User(myuser.getname(),myuser.getpassword,roles);
		// si el usuario no esta en userDet lanza la excepcion UsernameNotFoundException
		return userDet;
	}

}
