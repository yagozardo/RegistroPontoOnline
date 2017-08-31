/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.enums;

/**
 *
 * @author Alves
 */
public enum Departamento {
     
    FATURAMENTO("Faturamento"),
    FINCANCEIRO("Financeiro"),
    LIMPEZA("Limpeza"),
    MANUNTENCAO("Manuntenção"),
    MARKETING("Marketing"),
    RECEPCAO("Recepção"),
     RH("Gestão de Pessoas"),
    SUPORTE("Suporte ao usuário"),
    TI("Informática"),
    VENDAS("Vendas");

    private Departamento(String descricao) {
    
        this.descricao = descricao;
    }
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }
    
    
}
