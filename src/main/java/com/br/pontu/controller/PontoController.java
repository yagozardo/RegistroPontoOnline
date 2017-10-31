/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.pontu.services.PontoDataHoraServiceImpl;

/**
 *
 * @author sltnote-6354
 */
@Controller
public class PontoController {
    
	@Autowired
	private PontoDataHoraServiceImpl service;
	
    @GetMapping(value = {"", "/", "/index", "/home", "/ponto"})
    public String index() {
        return "/index";
    }
    
    @PostMapping("/ponto")
    public String registraPonto(@RequestParam String matricula, @RequestParam String password){
    	
       	service.baterPonto(matricula, password);
    	
        return ("redirect:/ponto");
    }
    
    
}
