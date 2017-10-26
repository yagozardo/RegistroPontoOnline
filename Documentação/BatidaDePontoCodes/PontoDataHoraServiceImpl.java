package com.br.pontu.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.pontu.entity.PontoDataHora;
import com.br.pontu.entity.User;
import com.br.pontu.repositories.PontoDataHoraRepository;
import com.br.pontu.repositories.UserRepository;

/**
 * 
 * @author Alves
 */

public class PontoDataHoraServiceImpl implements PontoDataHoraService {

	@Autowired
	private PontoDataHoraRepository pontoDataHoraRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean baterPonto(User user) {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dia = null;
		dia = Calendar.getInstance();
		String diaFormatado = dateFormat.format(dia.getTime());

		DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		Calendar hour = null;
		hour = Calendar.getInstance();
		String horaFormatado = hourFormat.format(hour.getTime());

		PontoDataHora ponto = new PontoDataHora();
		ponto.setDia(diaFormatado);
		ponto.setDia(horaFormatado);

		user.getPonto().add(ponto);

		this.userRepository.save(user);
		this.pontoDataHoraRepository.save(ponto);

		
		return true;
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

	private Boolean verificarUserESenha() {

		// TODO

		return false;
	}

	private Boolean verificarPontosRepetidos() {

		// TODO

		return false;
	}

}
