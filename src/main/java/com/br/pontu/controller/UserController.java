/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.pontu.services.PontoDataHoraServiceImpl;

/**
 *
 * @author sltnote-6354
 */

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private PontoDataHoraServiceImpl pontoDataHoraServiceImpl;
    
    @GetMapping("/profile")
    public String paginaUser(){
        return "/profile";
    }
    
//    @GetMapping("/{id}")
//    public List<diaComHoras> listaDiasComHoras(@PathVariable Long userId) {
//
//    	return pontoDataHoraServiceImpl.buscar30Dias(userId);
//    }
    
}
