
package com.br.pontu.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.pontu.entity.User;
import com.br.pontu.services.PontoDataHoraServiceImpl.diaComHoras;

/**
 * 
 * @author Alves
 */
@Service("pontoDataHoraService")
public interface PontoDataHoraService {
	
	public boolean baterPonto(String matricula, String password);
	
	public User editarPonto(User user);
	
	public void deletarPonto(User user);

	public List<diaComHoras> buscar30Dias(Long userId) throws SQLException;
	
	public void buscar60Dias();
	
	public void buscar90Dias();

	
	
}

