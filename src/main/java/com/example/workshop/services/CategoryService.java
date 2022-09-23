package com.example.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.Category;
import com.example.workshop.repositories.CategoryRepository;

@Service // registrando CategoryService como um Serviço do spring na camada de serviço
public class CategoryService {

	@Autowired // só com isso o próprio spring resolve esta dependência para que o spring faça essa injeção de dependência
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
