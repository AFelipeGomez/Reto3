package com.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "message")
@Data

public class Message  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMessage;
	
	@Column(name = "message_text")
	private String messageText;

	@ManyToOne
	@JoinColumn(name = "skate_id")
	@JsonIgnoreProperties({ "messages","reservations" })
	private Skate skate;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties({ "messages","reservations" })
	private Client client;

	public Message(Integer idMessage, String messageText, Skate skate, Client client) {

		this.idMessage = idMessage;
		this.messageText = messageText;
		this.skate = skate;
		this.client = client;
	}

	public Message() {

	}

	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Skate getSkate() {
		return skate;
	}

	public void setSkate(Skate skate) {
		this.skate = skate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
