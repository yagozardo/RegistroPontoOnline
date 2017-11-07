package com.br.pontu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.PontoData;

@Repository
public interface PontoDataRepository extends JpaRepository<PontoData, Long>{
	
	@Query(value = "SELECT * FROM ponto_data WHERE user_id = :userid", nativeQuery = true)
	List<PontoData> findByUserId(@Param("userid") Long userId);

}
