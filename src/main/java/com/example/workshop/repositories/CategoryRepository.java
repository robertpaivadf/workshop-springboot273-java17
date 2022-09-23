package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.Category;

//TRATA-SE DE UMA INTERFACE

public interface CategoryRepository extends JpaRepository<Category, Long> { // Passando o tipo da entidade (OCategory) e o tipo da
																	// chave dessa entidade (Long)
//só com essa definição já está pronto, não precisa implementar nenhum método, TOP!
//vai poder chamar CategoryRepository e usar diversos recursos para banco de dados	
}
