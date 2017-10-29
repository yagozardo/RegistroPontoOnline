/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sltnote-6354
 */
@Controller
public class LoginController {
   

    @GetMapping("/login")
    public ModelAndView login() {

        ModelAndView model = new ModelAndView("/login");
        return model;
    }
    
    @GetMapping("/acesso")
    public ModelAndView accessDenied(){
        ModelAndView model = new ModelAndView("/accessDenied");
        
        return model;
    }
}
