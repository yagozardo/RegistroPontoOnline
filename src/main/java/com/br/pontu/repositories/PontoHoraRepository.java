package com.br.pontu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.PontoHora;

@Repository
public interface PontoHoraRepository extends JpaRepository<PontoHora, Long>{

	//Query responsável por buscar os horários que sejam vinculados a um determinado dia
	//Params: Id do dia
	//Return: Lista de horários
	@Query(value = "SELECT hora FROM ponto_hora WHERE data_id = :diaid", nativeQuery = true)
	List<String> findByDayId(@Param("diaid") Long dia_id);

}
