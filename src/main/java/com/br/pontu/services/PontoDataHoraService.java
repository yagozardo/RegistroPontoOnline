
package com.br.pontu.services;

import org.springframework.stereotype.Service;

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

	public void buscar30Dias(String matricula);
	
	public void buscar60Dias();
	
	public void buscar90Dias();

	
	
}

