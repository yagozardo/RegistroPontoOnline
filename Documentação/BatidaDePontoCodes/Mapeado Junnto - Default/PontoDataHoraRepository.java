package com.br.pontu.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pontu.entity.PontoDataHora;

/**
 * 
 * @author Alves
 */
@Repository
public interface PontoDataHoraRepository extends JpaRepository<PontoDataHora, Integer>{

}
