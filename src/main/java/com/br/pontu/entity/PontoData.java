
package com.br.pontu.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ponto_data")
public class PontoData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	//Atributos =======================================================================
	private LocalDate dia;
	private User users;
	private List<PontoHora> hora;
	
	//Getters and Setters -------------------------------------------------------------
	
	@Id
	@NotNull
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	//@Temporal(TemporalType.DATE)
	public LocalDate getDia() {
		return dia;
	}
	public void setDia(LocalDate dia) {
		this.dia = dia;
	}
	

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	
	@OneToMany(mappedBy = "dia", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<PontoHora> getHora() {
		return hora;
	}
	public void setHora(List<PontoHora> hora) {
		this.hora = hora;
	}
	
}

