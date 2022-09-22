package com.example.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.workshop.entities.User_;
import com.example.workshop.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired //só com isso o próprio spring resolve esta dependência
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User_ u1 = new User_(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User_ u2 = new User_(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		//persistindo os dados no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2)); //userRepository.saveAll recebe uma lista
	}	
	
}
