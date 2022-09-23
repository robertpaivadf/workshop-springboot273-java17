package com.example.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.workshop.entities.Order;
import com.example.workshop.entities.User;
import com.example.workshop.entities.enums.OrderStatus;
import com.example.workshop.repositories.OrderRepository;
import com.example.workshop.repositories.UserRepository;

@Configuration // Use essa anotation para falar pro Spring que essa é uma classe de
				// configuração
@Profile("test") // O Spring só vai rodar essa configuração quando estiver no perfil de teste
public class TestConfig implements CommandLineRunner {

	@Autowired // só com isso o próprio spring resolve esta dependência
	private UserRepository userRepository;

	@Autowired // só com isso o próprio spring resolve esta dependência
	private OrderRepository orderRepository;

	// Um macete: A classe está implementando CommandLineRunner para usar o método
	// run, esse método executa quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PEYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PEYMENT, u1);

		// persistindo os dados no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2)); // userRepository.saveAll recebe uma lista
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // userRepository.saveAll recebe uma lista

	}

}
