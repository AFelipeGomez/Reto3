package com.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Data

public class Reservation  {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;

	@Column(name = "start_Date")
	private Date startDate;

	@Column(name = "devolution_Date")
	private Date devolutionDate;

	@Column(name = "status", length = 255)
	private String status;

	@ManyToOne
	@JoinColumn(name = "skate_id")
	@JsonIgnoreProperties("reservations")
	private Skate skate;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@JsonIgnoreProperties({ "messages","reservations" })
	private Client client;

	@OneToOne(mappedBy = "reservation")
	@JsonIgnoreProperties("reservation")
	private Score Score;

	public Reservation(Integer idReservation, Date startDate, Date devolutionDate, String status, Score score) {
		super();
		this.idReservation = idReservation;
		this.startDate = startDate;
		this.devolutionDate = devolutionDate;
		this.status = status;

		Score = score;
	}

	public Reservation() {
		super();
	}

	public Integer getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Score getScore() {
		return Score;
	}

	public void setScore(Score score) {
		Score = score;
	}

	

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Skate getSkate() {
		return skate;
	}

	public void setSkate(Skate skate) {
		this.skate = skate;
	}
}
