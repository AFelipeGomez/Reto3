package com.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Esta clase repesenta la entidad Skate
 * @author Andres Gomez
 */

@Entity
@Table(name = "skate")
@Data

public class Skate{

   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
         * Este es el campo nombre con longitud de 255 caracteres
         */
	@Column(name = "name", length = 255)
	private String name;

        /**
         * Este es el campo brand con longitud de 255 caracteres
         */
	@Column(name = "brand", length = 255)
	private String brand;
	
        /**
         * Este es el campo year tipo entero
         */
	@Column(name ="year")
	private Integer year;
	
        /**
         * Este es el campo description con longitud de 255 caracteres
         */
	@Column(name = "description", length = 255)
	private String description;

        /**
         * Esta es la relacion muchos a uno con category
         */
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnoreProperties("skates")	
	private Category category;
        /**
         * Esta es la relacion uno a muchos con messages
         */
	@OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "skate", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "skate", "client" })
	private List<Message> messages;

        /**
         * Esta es la relacion uno a muchos con reservations
         */
	@OneToMany(cascade = {CascadeType.MERGE},fetch = FetchType.LAZY, mappedBy = "skate")	
	@JsonIgnoreProperties({ "skate", "client" })
	private List<Reservation> reservations;

	public Skate(Integer id, String name, String brand, Integer year, String description, Category category,
			List<Message> messages, List<Reservation> reservations) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.year = year;
		this.description = description;
		this.category = category;
		this.messages = messages;
		this.reservations = reservations;
	}

	public Skate() {
		
	}

        /**
         * Metodos get y set de los campos y relaciones del entity
         * @return 
         */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


  

    
    
}
