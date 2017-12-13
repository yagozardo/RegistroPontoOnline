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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.pontu.entity.DiaComHoras;
import com.br.pontu.entity.User;
import com.br.pontu.services.PontoDataHoraServiceImpl;
import com.br.pontu.services.UserServiceImpl;

/**
 *
 * @author sltnote-6354 Alves
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PontoDataHoraServiceImpl pontoDataHoraServiceImpl;
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/portal")
    public String menu() {
        return "/portal";
    }

    @GetMapping("/espelho/{id}")
    public ModelAndView espelho(@PathVariable long id, User user) {
        ModelAndView model = new ModelAndView("/espelho");

        //List<DiaComHoras> list = pontoDataHoraServiceImpl.buscar30Dias(id);
        List<DiaComHoras> list = pontoDataHoraServiceImpl.mesSelecionado(id, "12", 2017);

        
        user = userService.findById(id);

        model.addObject("user", user);
        model.addObject("list", list);

        return model;
    }

}
