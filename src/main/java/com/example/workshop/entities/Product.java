package com.example.workshop.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // Anotations para que o JPA crie/atualize o banco de dados
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // Anotations para que o JPA crie/atualize os campos da entidade no banco de
	// dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define auto incremento no campo id
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgURL;

	// @Transient //Impede que o JPA tente interpretar isso aqui
	@ManyToMany // muitos pra muitos
	//o comando abaixo vai criar uma tabela associativa, isso porque trata-se de uma relação muitos para muitos
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();// precisa garantir que a coleção não começe nula, ela precisa
														// começar vazia por isso foi instanciada
														//O Set é uma interface que devemos instanciar a partir de outro objeto que a implemente, por exemplo
														// o new HashSet<>()

	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
	}

	public Product(Long id, String name, String description, Double price, String imgURL) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgURL = imgURL;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@JsonIgnore // para evitar loop infinito
	public Set<Order> getOrders(){
		Set<Order> set = new HashSet<>();
		for(OrderItem x : items) {
			set.add(x.getOrder());
		}
		return set;
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

}
