package com.br.pontu.entity;

import com.br.pontu.enums.SiglaEstados;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String numero;
    private String logradouro;  
    private String complemento;
    private String cidade; 
    private SiglaEstados uf;
    private String cep;

    
    
    //Getters and Setters ---------------------------------------------------------------------------
    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false, length = 10)
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 60)
    @Column(nullable = false, length = 60)
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    
    
    @Size(min = 3, max = 80)
    @Column(length = 80)
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    @Column(nullable = false, length = 30)
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="uf")
    public SiglaEstados getUf() {
        return uf;
    }
    public void setUf(SiglaEstados uf) {
        this.uf = uf;
    }

    
    @NotNull
    @NotEmpty
    @Size(min = 8, max = 10)
    @Column(nullable = false, length = 10)
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }


}
