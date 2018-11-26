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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.pontu.entity.User;
import com.br.pontu.services.UserServiceImpl;

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
    public ModelAndView paginaCadastro(User user) {
        ModelAndView model = new ModelAndView("/registro");
        model.addObject("user", user);

        return model;
    }

    @PostMapping("/registro")
    public String cadastraFuncionario(User user) {

        userService.cadastrarUsuario(user, true);

        return ("redirect:/admin/registro");
    }

    @GetMapping("/lista")
    public ModelAndView listaUsers(User user) {
        ModelAndView model = new ModelAndView("/listaUsers");
        List<User> list = userService.getAllUsers();

        model.addObject("list", list);

        return model;

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deletarUsuario(id);
        return ("redirect:/admin/lista");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editarUser(@PathVariable int id, User user) {
        ModelAndView model = new ModelAndView("/editar");

        user = userService.findById(id);

        model.addObject("user", user);

        return model;
    }

    @PostMapping("/edit")
    public String editaFuncionario(User user) {

        userService.cadastrarUsuario(user, false);

        return ("redirect:/admin/registro");
    }

    @GetMapping("/user/{id}")
    public ModelAndView getUser(@PathVariable int id, User user) {
        ModelAndView model = new ModelAndView("/user");

        user = userService.findById(id);

        model.addObject("user", user);

        return model;
    }

    @GetMapping("/menu")
    public String menu() {
        return "/menu";
    }

}
