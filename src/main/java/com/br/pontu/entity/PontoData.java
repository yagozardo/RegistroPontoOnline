
package com.br.pontu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ponto_data")
public class PontoData implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	// =======================================================================
	private Long id;
	private String dia;
	private Long userId;
	private List<User> usuario;
	private List<PontoHora> horas;
	
	
	// Getters and Setters
	// -------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@NotBlank
	@Column(nullable = false)
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}


	@NotNull
	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "datas_horas", joinColumns = @JoinColumn(name = "id_data"), inverseJoinColumns = @JoinColumn(name = "id_hora"))
	public List<PontoHora> getHoras() {
		return horas;
	}
	public void setHoras(List<PontoHora> horas) {
		this.horas = horas;
	}
	
	@ManyToMany(mappedBy = "ponto")
	public List<User> getUsuario() {
		return usuario;
	}
	public void setUsuario(List<User> usuario) {
		this.usuario = usuario;
	}
	
	// Equals and Hashcode --------------------------------------------------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PontoData other = (PontoData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
