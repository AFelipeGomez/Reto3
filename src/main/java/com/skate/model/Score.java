package com.skate.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "score")
@Data

public class Score  {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "message_text", nullable = false, length = 255)
	private String messageText;
	
	@Column(name = "starts")
	private Integer starts;
	
	@OneToOne
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	public Score(Integer id, String messageText, Integer starts, Reservation reservation) {
		super();
		this.id = id;
		this.messageText = messageText;
		this.starts = starts;
		this.reservation = reservation;
	}

	public Score() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Integer getStarts() {
		return starts;
	}

	public void setStarts(Integer starts) {
		this.starts = starts;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
        
        
}
