package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.Product;

//TRATA-SE DE UMA INTERFACE

public interface ProductRepository extends JpaRepository<Product, Long> { // Passando o tipo da entidade (OProduct) e o tipo da
																	// chave dessa entidade (Long)
//só com essa definição já está pronto, não precisa implementar nenhum método, TOP!
//vai poder chamar ProductRepository e usar diversos recursos para banco de dados	
}
