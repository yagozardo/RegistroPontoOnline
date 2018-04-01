package com.br.pontu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.User;

/**
 *
 * @author Robson - Alves
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    List<User> findByMatriculaAndPassword(String matricula, String password);
    
    User findByMatricula(String matricula);

}
