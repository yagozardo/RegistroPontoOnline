/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.enums;

/**
 *
 * @author sltnote-6354
 */
public enum Role {
    
    Admin("Administrador"),
    User("Usuário");
    
    private String descricao;
    
    Role(String descricao) {
     
        this.descricao = descricao;
    }    

    public String getDescricao() {
        return descricao;
    }
    
    
}
