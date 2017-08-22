package com.br.pontu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe utilitária que é para armazenamento tanto de um funcionário, quanto de
 * uma empresa cadastrada quanto um possível cliente e fornecedor pensando em um
 * sistema mais robusto.
 *
 * @author Alves
 */
@Entity
@Table(name = "endereco_usuario")
public class Adress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Atributos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Long numero;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 60)
    private String logradouro;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 80)
    private String complemento;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 30)
    private String cidade;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 2)
    private String uf;

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 8)
    private String cep;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

}
