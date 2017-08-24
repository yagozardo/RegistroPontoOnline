package com.br.pontu.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pontu.entity.Times;

/**
 * 
 * @author Alves
 */
@Repository
public interface TimesRepository extends JpaRepository<Times, Integer>{

}
