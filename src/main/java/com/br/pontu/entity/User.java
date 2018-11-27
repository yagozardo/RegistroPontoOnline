package com.br.pontu.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.br.pontu.enums.Departamento;
import com.br.pontu.enums.EstadoCivil;
import com.br.pontu.enums.Role;

/**
 * Entidade que é responsável pelo dados dos usuários Sendo eles de carater
 * administrador ou funcionários Sendo separados por niveis de acesso em suas
 * funções
 *
 * @author Alves
 */
@Entity
@Table(name = "usuario")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos Inicio
	// =========================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String sobrenome;

	@Column(nullable = false, length = 10)
	private String dataNascimento;

	@NotNull
	@Column(unique = true)
	private String cpf;

	@NotNull
	@Column(unique = true)
	private String carteiraDeTrabalho;

	@NotNull
	@Size(min = 1, max = 20)
	@Column(unique = true)
	private String rg;

	@NotNull
	private String celular;

	@Size(max = 16)
	private String fixo;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 60)
	private EstadoCivil estadoCivil;

	@Email
	@Size(max = 60)
	@Column(nullable = false, length = 60, unique = true)
	private String email;

	@NotNull
	@Column(name = "cargo", nullable = false, length = 60)
	private String cargo;

	@NotNull
	@Column(nullable = false, length = 5)
	private String matricula;

	@NotNull
	@Column(name = "password", length = 100)
	private String password;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role acesso;

	@Embedded
	private Adress endereco;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 60)
	private Departamento departamento;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_datas", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_data"))
	private List<PontoData> ponto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}

	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	public List<PontoData> getPonto() {
		return ponto;
	}

	public void setPonto(List<PontoData> ponto) {
		this.ponto = ponto;
	}

	public Adress getEndereco() {
		return endereco;
	}

	public void setEndereco(Adress endereco) {
		this.endereco = endereco;
	}

	public Role getAcesso() {
		return acesso;
	}

	public void setAcesso(Role acesso) {
		this.acesso = acesso;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carteiraDeTrabalho == null) ? 0 : carteiraDeTrabalho.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (carteiraDeTrabalho == null) {
			if (other.carteiraDeTrabalho != null) {
				return false;
			}
		} else if (!carteiraDeTrabalho.equals(other.carteiraDeTrabalho)) {
			return false;
		}
		if (celular == null) {
			if (other.celular != null) {
				return false;
			}
		} else if (!celular.equals(other.celular)) {
			return false;
		}
		if (cpf == null) {
			if (other.cpf != null) {
				return false;
			}
		} else if (!cpf.equals(other.cpf)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (rg == null) {
			if (other.rg != null) {
				return false;
			}
		} else if (!rg.equals(other.rg)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nome=" + nome + ", ponto=" + ponto + "]";
	}
}
