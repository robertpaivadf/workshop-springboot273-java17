package com.example.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.Order;
import com.example.workshop.repositories.OrderRepository;

@Service // registrando OrderService como um Serviço do spring na camada de serviço
public class OrderService {

	@Autowired // só com isso o próprio spring resolve esta dependência para que o spring faça
				// essa injeção de dependência
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
