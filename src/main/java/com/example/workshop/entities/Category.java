package com.example.workshop.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // Anotations para que o JPA crie/atualize o banco de dados
@Table(name = "tb_category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // Anotations para que o JPA crie/atualize os campos da entidade no banco de
		// dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define auto incremento no campo id
	private Long id;
	private String name;
	
	//@Transient //Impede que o JPA tente interpretar isso aqui
	@ManyToMany(mappedBy = "categories")
	@JsonIgnore //para evitar loops
	private Set<Product> products = new HashSet<>(); //obrigatório instanciar

	public Category() {
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	public Set<Product> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}

	
	

}
