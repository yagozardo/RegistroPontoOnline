/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.services;

import com.br.pontu.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Robson
 */
@Service("userService")
public interface UserService {

    public List<User> findByMatriculaAndPassword(String matricula, String password);

    public User cadastrarUsuario(User user);

    public List<User> getAllUsers();

    public void deletarUsuario(long id);

    public User findById(long id);
    
    public List<User> findByMatricula(String matricula);

}
