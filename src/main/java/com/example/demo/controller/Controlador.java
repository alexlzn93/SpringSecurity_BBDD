package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.interfaces.IUserSERVICE;
import com.example.demo.model.User1;
import com.example.demo.model.Usuario;


@Controller
public class Controlador {
	@Autowired
	IUserSERVICE userService;
	@Autowired
	List<Usuario> usuarios;
	@Autowired
	BCryptPasswordEncoder bycript;
	// he creado un index.html que arranca por defecto  http://localhost:8080
	//http://localhost:8080/greeting
	//http://localhost:8080/greeting?name=pepe
	@GetMapping("/saludo")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Juan") String name, Model model) {
      	model.addAttribute("name", name);
        return "saludo";
    }
	@GetMapping("/listusuarios")
    public String list(Model model) {
	//  tema seguridad encriptar pass
		
		// usuarios lo cargo por inyeccion
		model.addAttribute("usuarios", usuarios);
        return "listusuarios";
    }
	@GetMapping("/login")
    public String login(Model model) {
	      return "login";
    }
	@GetMapping("/publico")
    public String publico(Model model) {
		System.out.println(bycript.encode("123"));
	      return "publico";
    }
	@GetMapping("/paginaregistro")
    public String paginaregistro() {
		    return "registro";
    }
	@GetMapping("/registro")
    public String registro(HttpServletRequest request) {
		User1 user1=new User1(request.getParameter("user"),
				bycript.encode(request.getParameter("password")),
				request.getParameter("email"));
		userService.add_user(user1);
		return "login";
    }
}
