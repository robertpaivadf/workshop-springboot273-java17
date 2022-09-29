package com.example.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.User;
import com.example.workshop.repositories.UserRepository;

@Service // registrando UserService como um Serviço do spring na camada de serviço
public class UserService {

	@Autowired // só com isso o próprio spring resolve esta dependência para que o spring faça essa injeção de dependência
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //não vai no banco de dados, apenas cria um obj monitorado, ele só prepara o obj pra vc mexer e depois é que faz operação no BD
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());		
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	
	
	

}
