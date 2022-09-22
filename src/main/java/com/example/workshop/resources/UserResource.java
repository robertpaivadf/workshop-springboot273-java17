package com.example.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.entities.User_;
import com.example.workshop.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
//Camada de Recurso que são os controladores REST --> Serviços(services) --> Dados (repositories)

	@Autowired //para o spring já fazer a injeção de dependência --> UserResource que depende de UserService
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User_>> findAll() {
		List<User_> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User_> findById(@PathVariable Long id) {
		User_ obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
