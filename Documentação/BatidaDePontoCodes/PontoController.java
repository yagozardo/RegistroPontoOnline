/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.pontu.entity.User;

/**
 * Esta classe é responsável por 
 * 
 *
 * @author sltnote-6354 ALVES
 */
@Controller
@RequestMapping("/sistema")
public class PontoController {
    
	@Autowired
	private PontoDataHoraServiceImpl service;
	
	
    @GetMapping("/inicio")
    public String paginaBatida(){
        
        return "/index";
    }
    
    @PostMapping("/inicio")
    public String registraPonto(@PathVariable String matricula, @PathVariable String password){
    	
    	service.baterPonto(matricula, password);
    	
        return ("redirect: /index");
    }
    
    
}
