/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.User;

/**
 *
 * @author Robson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    List<User> findByMatriculaAndPassword(String matricula, String password);


}
