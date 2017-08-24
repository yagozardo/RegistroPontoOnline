package com.br.pontu.services;

import org.springframework.stereotype.Service;

import com.br.pontu.entity.User;

/**
 * 
 * @author Alves
 */
@Service("timesService")
public interface TimesService {
	
	public boolean baterPonto(Long matricula, String Senha);
	
	public User editarPonto(User user);
	
	public void deletarPonto(User user);

}
