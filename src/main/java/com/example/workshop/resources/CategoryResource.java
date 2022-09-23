package com.example.workshop.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.entities.Category;
import com.example.workshop.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") // lá no postman no GET pode se usar : http://localhost:8080/users
public class CategoryResource {
//Camada de Recurso que são os controladores REST --> Serviços(services) --> Dados (repositories)

	@Autowired //para o spring já fazer a injeção de dependência --> CategoryResource que depende de CategoryService
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() { //ResponseEntity é um tipo específico do Spring para retornar reseposta de requisiçoes web
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list); //vai retornar no navegador um objeto já no padrão JASON, por exemplo: {"id":1,"name":"Maria Brown","email":"maria@gmail.com","phone":"988888888","password":"123456"} 
	}
	
	@GetMapping(value="/{id}") // lá no postman no GET pode se usar : http://localhost:8080/users/{id} ou seja, /1 ou /2 etc...
	public ResponseEntity<Category> findById(@PathVariable Long id) { //Use @PathVariable pro spring entender que haverá parâmentros vindo de requisição
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
