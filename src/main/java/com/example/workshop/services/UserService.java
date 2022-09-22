package com.example.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.User_;
import com.example.workshop.repositories.UserRepository;

@Service // registrando como um serviço do spring
public class UserService {

	@Autowired // só com isso o próprio spring resolve esta dependência para que o spring faça
				// essa injeção de dependência
	private UserRepository repository;

	public List<User_> findAll() {
		return repository.findAll();
	}
	
	public User_ findById(Long id) {
		Optional<User_> obj = repository.findById(id);
		return obj.get();
	}

}
