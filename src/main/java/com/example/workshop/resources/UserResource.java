package com.example.workshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
//Camada de Recurso que são os controladores REST --> Serviços --> Dados

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "aaria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
