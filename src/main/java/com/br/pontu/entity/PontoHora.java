
package com.br.pontu.entity;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ponto_hora")
public class PontoHora implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	//Atributos =======================================================================
	private PontoData hdia;
	private LocalTime hora;
	
	//Getters and Setters -------------------------------------------------------------
	
	
	@Id
	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "HH:mm")
	//@Temporal(TemporalType.TIME)
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "data_id", nullable = false)
	public PontoData getHdia() {
		return hdia;
	}
	public void setHdia(PontoData hdia) {
		this.hdia = hdia;
	}
}

