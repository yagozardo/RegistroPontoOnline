package com.br.pontu.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.pontu.entity.Times;
import com.br.pontu.entity.User;
import com.br.pontu.repositories.TimesRepository;
import com.br.pontu.repositories.UserRepository;

/**
 * 
 * @author Alves
 */

public class TimesServiceImpl implements TimesService {

	@Autowired
	TimesRepository timesRepository;
	UserRepository userRepository;

	@Override
	public boolean baterPonto(Long matricula, String Senha) {

		User comparator = null;

		comparator = userRepository.getOne(matricula);

		if (comparator == null) {

			return false;

		} else {

			// TODO implementar a criptografia de senha e armazen-lá na memória
			// para comparação
			String Hash = null;
			
			if (comparator.getSenha() == Hash) {
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar dia = null;
				dia = Calendar.getInstance();
				String diaFormatado = dateFormat.format(dia.getTime());
				
				DateFormat hourFormat = new SimpleDateFormat("HH:mm");
				Calendar hour = null;
				hour = Calendar.getInstance();
				String horaFormatado = dateFormat.format(hour.getTime());
				
				Times times = null;
				
				// TODO implementar a busca no banco para caso já haja a data de hoje.
				
			
				
				return true;
			
			} else {
				
				return false;
			}
			

		}

	}

	@Override
	public User editarPonto(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarPonto(User user) {
		// TODO Auto-generated method stub

	}

}

