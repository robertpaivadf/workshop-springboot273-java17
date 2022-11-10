package com.example.workshop.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.workshop.entities.User;
import com.example.workshop.services.UserService;

@RestController
@RequestMapping(value = "/users") // lá no postman no GET pode se usar : http://localhost:8080/users


//UserResource é um controlador REST
public class UserResource {
//Camada de Recurso que são os controladores REST --> Serviços(services) --> Dados (repositories)

	@Autowired //para o spring já fazer a injeção de dependência --> UserResource que depende de UserService
	private UserService service;
	
	@GetMapping //usa-se o GET para recuperar dados
	public ResponseEntity<List<User>> findAll() { //ResponseEntity é um tipo específico do Spring para retornar reseposta de requisiçoes web
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); //vai retornar no navegador um objeto já no padrão JASON, por exemplo: {"id":1,"name":"Maria Brown","email":"maria@gmail.com","phone":"988888888","password":"123456"} 
	}
	
	@GetMapping(value="/{id}") // lá no postman no GET pode se usar : http://localhost:8080/users/{id} ou seja, /1 ou /2 etc...
	public ResponseEntity<User> findById(@PathVariable Long id) { //Use @PathVariable pro spring entender que haverá parâmentros vindo de requisição
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //ResponseEntity.ok() para retornar a resposta de sucesso do HTTP e no corpo da resposta (.body(obj)) vai colocar a lista
	}
	
	
	@PostMapping //usa-se para inserir    
	public ResponseEntity<User> insert(@RequestBody User obj){ //Usa-se notation @RequestBody para receber o objeto Jason
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); //tudo isso para gerar o retorno 201 lá no Jason que é 201=criando objeto
	}
	
	@DeleteMapping(value="/{id}") //usa-se para deletar
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);		
		return ResponseEntity.noContent().build(); //resposta sem corpo e o código http será 204
	}
	
	@PutMapping(value="/{id}") //usa-se para atualizar dados
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}
