package com.br.pontu.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pontu.services.PontoDataHoraServiceImpl;
import com.br.pontu.services.PontoDataHoraServiceImpl.DiaComHoras;

@RestController
@RequestMapping("/foda")
public class EspelhoController {
	
	@Autowired
	private PontoDataHoraServiceImpl pontoDataHoraServiceImpl;

    
    @PostMapping
    public List<DiaComHoras> listaDiasComHoras() throws SQLException {

    	Long userId = (long) 15;
    	return pontoDataHoraServiceImpl.buscar30Dias(userId);
    }

}
