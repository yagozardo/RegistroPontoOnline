/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import com.br.pontu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sltnote-6354
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/registro")
    public ModelAndView paginaCadastro(User user){
        ModelAndView model = new ModelAndView("/registro");
        model.addObject("user",user);
        
        return model;
    }
    
    @PostMapping("/registro")
    public String cadastraFuncionario(){
        return ("redirect: /registro");
    }
    
    
}
