
package com.br.pontu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ponto_data")
public class PontoData implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	//Atributos =======================================================================
	private String dia;
	//private String hora;
	private User users;
	private List<PontoHora> hora;
	
	//Getters and Setters -------------------------------------------------------------
	
	@Id
	@NotNull
	@Column(nullable = false)
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	
//	@NotNull
//	@NotBlank
//	@Column(nullable = false)
//	public String getHora() {
//		return hora;
//	}
//	public void setHora(String hora) {
//		this.hora = hora;
//	}
	
	
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

