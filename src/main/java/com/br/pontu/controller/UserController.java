/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.pontu.services.PontoDataHoraServiceImpl;
import com.br.pontu.services.PontoDataHoraServiceImpl.diaComHoras;

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
    
    @GetMapping
    public List<diaComHoras> listaDiasComHoras() throws SQLException {

    	Long userId = (long) 1;
    	return pontoDataHoraServiceImpl.buscar30Dias(userId);
    }
    
}
