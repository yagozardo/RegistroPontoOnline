package com.br.pontu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pontu.entity.DiaComHoras;
import com.br.pontu.services.PontoDataHoraServiceImpl;

/**
 * 
 * @author Alves
 * @since 12/11/2017
 */
@RestController
@RequestMapping("/espelho")
public class EspelhoController {
	
	@Autowired
	private PontoDataHoraServiceImpl pontoDataHoraServiceImpl;

    
    @PostMapping
    public List<DiaComHoras> listaDiasComHoras(@RequestBody Long userId) {

    	return pontoDataHoraServiceImpl.buscar30Dias(userId);
    }

}
