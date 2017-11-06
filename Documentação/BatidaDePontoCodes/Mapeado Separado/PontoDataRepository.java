package com.br.pontu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoDataRepository extends JpaRepository<PontoData, Long>{

}
