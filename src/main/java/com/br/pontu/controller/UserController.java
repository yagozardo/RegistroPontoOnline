/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.pontu.entity.DiaComHoras;
import com.br.pontu.services.PontoDataHoraServiceImpl;

/**
 *
 * @author sltnote-6354 Alves
 */

@Controller
@RequestMapping("/resumo")
public class UserController {

	@Autowired
	private PontoDataHoraServiceImpl pontoDataHoraServiceImpl;
	
	@GetMapping()
    public ModelAndView espelho(){
        ModelAndView model = new ModelAndView("/espelho");
        
        List<DiaComHoras> list = pontoDataHoraServiceImpl.buscar30Dias(1L);
        model.addObject("list", list);
        
        return model;
    }
    
}
