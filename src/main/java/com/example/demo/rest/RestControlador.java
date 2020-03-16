package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;

@RestController
@RequestMapping("/restusuarios")
public class RestControlador {
	
	@Autowired
	List<Usuario> usuarios;
	
	//http://localhost:8080/restusuarios
	@GetMapping  // listar
	public List<Usuario> list() {
		// usuarios va por inyeccion
		return usuarios;
    }
	
	@GetMapping(value = {"/{id}"})  // delete
    public void List(@PathVariable("id") Integer id) {
		System.out.println("id="+id);
		// borramos un usuario
    }
	@PostMapping  // insertar
    public void insertar(Usuario u) {
		// insertariamos un usuario
    }
	
	@PutMapping  // modificar
    public void update(Usuario u) {
		// update un usuario
    }
	
	@DeleteMapping(value = {"/{id}"})  // delete
    public void delete(@PathVariable("id") Integer id) {
		System.out.println("id="+id);
		// borramos un usuario
    }
}
