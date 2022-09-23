package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.User;

//TRATA-SE DE UMA INTERFACE

public interface UserRepository extends JpaRepository<User, Long> { // Passando o tipo da entidade (OOrderItem) e o tipo da
																	// chave dessa entidade (Long)
//só com essa definição já está pronto, não precisa implementar nenhum método, TOP!
//vai poder chamar UserRepository e usar diversos recursos para banco de dados	
}
