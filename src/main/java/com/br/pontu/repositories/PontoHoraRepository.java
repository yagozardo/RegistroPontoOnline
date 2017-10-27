package com.br.pontu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.PontoHora;

@Repository
public interface PontoHoraRepository extends JpaRepository<PontoHora, Long>{

}
