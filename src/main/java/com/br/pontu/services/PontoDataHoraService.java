
package com.br.pontu.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.pontu.entity.DiaComHoras;
import com.br.pontu.entity.User;

/**
 * 
 * @author Alves
 */
@Service("pontoDataHoraService")
public interface PontoDataHoraService {
	
	public boolean baterPonto(String matricula, String password);
	
	public User editarPonto(User user);
	
	public void deletarPonto(User user);

	public List<DiaComHoras> buscar30Dias(Long userId);
	
	public List<DiaComHoras> mesSelecionado(Long userId, String mes, int ano);
	
}

