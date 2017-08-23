/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import com.br.pontu.entity.Adress;
import com.br.pontu.entity.User;
import com.br.pontu.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    UserServiceImpl userService;
    
    @GetMapping("/registro")
    public ModelAndView paginaCadastro(User user, Adress adress){
        ModelAndView model = new ModelAndView("/registro");
        model.addObject("user",user);
        
        
        return model;
    }
    
    @PostMapping("/registro")
    public String cadastraFuncionario(User user){
        
        userService.cadastrarUsuario(user);
        
        return ("redirect:/admin/registro");
    }
    
    
}
