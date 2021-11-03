package com.skate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data

public class Client {

   @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idClient;
   
        @Column(name = "email", length = 255)
	private String email;

	@Column(name = "password", length = 255)
	private String password;

	@Column(name = "name", length = 255)
	private String name;	

	@Column(name = "age")
	private int age;

	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "client", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("client")
	public List<Message> messages;

	@OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST })
	@JsonIgnoreProperties("client")
	private List<Reservation> reservations;

	public Client(Integer idClient, String name, String email, String password, int age, List<Message> messages,
			List<Reservation> reservations) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.messages = messages;
		this.reservations = reservations;
	}
	

	public Client() {
		super();
	}


	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
