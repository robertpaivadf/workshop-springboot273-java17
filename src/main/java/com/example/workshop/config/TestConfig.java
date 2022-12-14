package com.example.workshop.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.workshop.entities.Category;
import com.example.workshop.entities.Order;
import com.example.workshop.entities.OrderItem;
import com.example.workshop.entities.Payment;
import com.example.workshop.entities.Product;
import com.example.workshop.entities.User;
import com.example.workshop.entities.enums.OrderStatus;
import com.example.workshop.repositories.CategoryRepository;
import com.example.workshop.repositories.OrderItemRepository;
import com.example.workshop.repositories.OrderRepository;
import com.example.workshop.repositories.ProductRepository;
import com.example.workshop.repositories.UserRepository;

@Configuration // Use essa anotation para falar pro Spring que essa é uma classe de
				// configuração
@Profile("test") // O Spring só vai rodar essa configuração quando estiver no perfil de teste
public class TestConfig implements CommandLineRunner {
	
	@Autowired // só com isso o próprio spring resolve esta dependência
	private UserRepository userRepository;

	@Autowired // só com isso o próprio spring resolve esta dependência
	private OrderRepository orderRepository;

	@Autowired // só com isso o próprio spring resolve esta dependência
	private CategoryRepository categoryRepository;

	@Autowired // só com isso o próprio spring resolve esta dependência
	private ProductRepository productRepository;

	@Autowired // só com isso o próprio spring resolve esta dependência
	private OrderItemRepository orderItemRepository;

	// Um macete: A classe está implementando CommandLineRunner para usar o método
	// run, esse método executa quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); // userRepository.saveAll recebe uma lista
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // userRepository.saveAll recebe uma lista

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); // userRepository.saveAll recebe uma lista

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PEYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PEYMENT, u1);

		// persistindo os dados no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2)); // userRepository.saveAll recebe uma lista
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); // userRepository.saveAll recebe uma lista

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4)); // userRepository.saveAll recebe uma lista
		
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		//IMPORTANTE, para salvar um objeto dependente numa relação um para um não deve chamar o repository do objeto dependente
		//invez disso faça assim:
		o1.setPayment(pay1); //associou o pedido 1 com o pagamento 1
		orderRepository.save(o1);//depois é só salvar o objeto o1
		
		
		//testando o postRequest
		//PostRequest.executa();
		
		String sJson = "{\r\n"
						+ " \"name\": \"John Heberth\",\r\n"
						+ " \"email\": \"john@gmail.com\",\r\n"
						+ " \"phone\": \"9999999999\",\r\n"
						+ " \"password\": \"12345678\"\r\n"
						+ "}";		
	
		//chamada PostRequest	
		PostRequest.executaJson2("http://localhost:8080/users", sJson);
	

	}

}
