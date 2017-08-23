/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.services;

import com.br.pontu.entity.User;
import com.br.pontu.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User cadastrarUsuario(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<User> itr = userRepository.findAll();
        return (List<User>) itr;
    }

    @Override
    public void deletarUsuario(long id) {
        
        userRepository.delete(id);
    }

}
