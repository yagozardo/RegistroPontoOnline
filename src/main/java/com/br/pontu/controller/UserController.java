/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sltnote-6354
 */

@Controller
@RequestMapping("/espelho")
public class UserController {

    
    @GetMapping("/resumo")
    public String paginaUser(){
        return "/espelho";
    }
    
}
