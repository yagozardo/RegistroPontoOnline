
package com.br.pontu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name = "ponto")
public class PontoDataHora implements Serializable{
//
//	private static final long serialVersionUID = 1L;
//	
//	
//	/**
//	 * Atributos =======================================================================
//	 */
//	private String dia;
//	private List<String> horarios;
//	private User users;
//	
//	
//	//Getters and Setters -------------------------------------------------------------
//	@NotNull
//	@Temporal(TemporalType.DATE)
//	@Column(nullable = false)
//        @Id
//	public String getDia() {
//		return dia;
//	}
//	public void setDia(String dia) {
//		this.dia = dia;
//	}
//	
//	@NotNull
//	@Temporal(TemporalType.TIME)
//	public List<String> getHorarios() {
//		return horarios;
//	}
//	public void setHorarios(List<String> horarios) {
//		this.horarios = horarios;
//	}
//	
//	@ManyToOne
//	@JoinColumn(name = "user_id", nullable = false)
//	public User getUsers() {
//		return users;
//	}
//	public void setUsers(User users) {
//		this.users = users;
//	}
//	

}

