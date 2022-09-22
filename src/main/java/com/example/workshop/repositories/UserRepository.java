package com.example.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.User_;


public interface UserRepository extends JpaRepository<User_, Long>{
//só com essa definição já está pronto, não precisa implementar nenhum método, TOP!
}
