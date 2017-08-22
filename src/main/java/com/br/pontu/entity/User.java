
package com.br.pontu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Entidade que é responsável pelo dados dos usuários
 * Sendo eles de carater administrador ou funcionários
 * Sendo separados por niveis de acesso em suas funções
 * @author Alves
 */

@Entity
@Table(name = "usuario")
public class User implements Serializable {
 
	private static final long serialVersionUID = 1L;
	
	/*
	 * Atributos
	 */
	private Long id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String cpf;
    private String carteiraDeTrabalho;
    private String rg;
    private String celular;
    private String fixo;
    private EstadoCivil estadoCivil;
    private Adress endereco;
    
    private String login;
    private String senha;
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 15)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 60)
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 13)
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 20)
	public String getCarteiraDeTrabalho() {
		return carteiraDeTrabalho;
	}
	public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
		this.carteiraDeTrabalho = carteiraDeTrabalho;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 20)
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	

	//Este Atributo pode ser opcional, sendo não é necessário 
	//Validação
	@Column(length = 20)
	public String getFixo() {
		return fixo;
	}
	public void setFixo(String fixo) {
		this.fixo = fixo;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable =  false, length = 60)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	public Adress getEndereco() {
		return endereco;
	}
	public void setEndereco(Adress endereco) {
		this.endereco = endereco;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 20)
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@NotNull
	@NotEmpty
	@Column(nullable =  false, length = 20)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    
    
    
    
    
}
