package com.example.workshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//IMPORTANTE: Foi necessário usar o nome da classe como User_ tendo em vista que existe uma palavra reservada "user" no banco H2
//ao utilizar user estava gerando erro na aplicação spring boot

@Entity // Anotations para que o JPA crie/atualize o banco de dados
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// Usa-se a interface Serializable quando você quer que os seus objetos possam
	// ser
	// transformados em cadeias de bytes para que o obj trafegue na rede para que
	// possa ser gravado em arquivo, etc...

	@Id // Anotations para que o JPA crie/atualize os campos da entidade no banco de
		// dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define auto incremento no campo id
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	// criando associações
	@JsonIgnore //Devido a associação de Oder com User é obrigatório colocar essa anotation de um dos lados pra não gerar loop infinito
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>(); // um OUser possui vários OOrder

	public User() { // obrigatório usar o construtor vazio para o framework
	}

	public User(Long id, String name, String email, String phone, String password) {
		// super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
