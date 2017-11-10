package com.br.pontu.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.pontu.entity.PontoData;
import com.br.pontu.services.PontoDataHoraServiceImpl.diaComHoras;

@Repository
public interface PontoDataRepository extends JpaRepository<PontoData, Long>{
	
	//Params: Id do usuário e o dia em questão
	//Return: Lista de datas
	@Query(value = "SELECT * FROM ponto_data WHERE user_id = :userid AND dia = :diaF", nativeQuery = true)
	List<PontoData> findByUserId(@Param("userid") Long userId, @Param("diaF") String diaFormatado);
	
	
    //Query resposável por buscar os últimos 30 dias e os horários de ponto de um determinado usuário.
	//Params: Id do usuário, data com 30 dias atrás, data atual.
	//Return: Dias e horas.
	@Query(value = "SELECT dia, hora FROM ponto_data INNER JOIN ponto_hora ON ponto_data.id = ponto_hora.data_id WHERE ponto_data.user_id = :user_id AND dia BETWEEN :data_anterior AND :data_atual", nativeQuery = true)
	List<diaComHoras> findLastDays(@Param("user_id") Long userId, @Param("data_anterior") String dataAnterior, @Param(value = "data_atual")String dataAtual);


}
