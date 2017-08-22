package com.br.pontu.entity;

import com.br.pontu.enums.EstadoCivil;
import com.br.pontu.enums.role;
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

    /*
	 * Atributos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 15)
    private String nome;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 60)
    private String sobrenome;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 13)
    private String cpf;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 20)
    private String carteiraDeTrabalho;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 20)
    private String rg;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private String celular;

    @Column(length = 20)
    private String fixo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 60)
    private EstadoCivil estadoCivil;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private role acesso;

    public role getAcesso() {
        return acesso;
    }

    public void setAcesso(role acesso) {
        this.acesso = acesso;
    }

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Adress endereco;

//    @NotNull
//    @NotEmpty
//    @Column(nullable = false, length = 20)
//    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    //Este Atributo pode ser opcional, sendo não é necessário 
    //Validação
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


    public Adress getEndereco() {
        return endereco;
    }

    public void setEndereco(Adress endereco) {
        this.endereco = endereco;
    }

//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
}
