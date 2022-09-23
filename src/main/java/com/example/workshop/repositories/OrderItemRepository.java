package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.OrderItem;

//TRATA-SE DE UMA INTERFACE

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> { // Passando o tipo da entidade (OUser) e o
																				// tipo da
	// chave dessa entidade (Long)
//só com essa definição já está pronto, não precisa implementar nenhum método, TOP!
//vai poder chamar OrderItemRepository e usar diversos recursos para banco de dados	
}
