package com.example.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.Product;
import com.example.workshop.repositories.ProductRepository;

@Service // registrando ProductService como um Serviço do spring na camada de serviço
public class ProductService {

	@Autowired // só com isso o próprio spring resolve esta dependência para que o spring faça essa injeção de dependência
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
