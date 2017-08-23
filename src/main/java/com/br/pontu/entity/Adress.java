package com.br.pontu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe utilitária que é para armazenamento tanto de um funcionário, quanto de
 * uma empresa cadastrada quanto um possível cliente e fornecedor pensando em um
 * sistema mais robusto.
 *
 * @author Alves
 */

@Embeddable
public class Adress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Atributos ===================================================================================
     */
    private Long numero;
    private String logradouro;  
    private String complemento;
    private String cidade; 
    private String uf;
    private String cep;

    
    
    //Getters and Setters ---------------------------------------------------------------------------
    @NotNull
    @Column(nullable = false)
    public Long getNumero() {
        return numero;
    }
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    

    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 60)
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 80)
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 30)
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 2)
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

    
    @NotNull
    @NotEmpty
    @Column(nullable = false, length = 8)
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


}