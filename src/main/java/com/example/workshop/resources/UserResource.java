package com.example.workshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.entities.User_;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
//Camada de Recurso que são os controladores REST --> Serviços(services) --> Dados (repositories)

	@GetMapping
	public ResponseEntity<User_> findAll() {
		User_ u = new User_(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
