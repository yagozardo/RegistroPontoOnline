package com.br.pontu.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pontu.entity.PontoData;
import com.br.pontu.entity.PontoHora;
import com.br.pontu.entity.User;
import com.br.pontu.repositories.PontoDataRepository;
import com.br.pontu.repositories.PontoHoraRepository;
import com.br.pontu.repositories.UserRepository;

/**
 * 
 * @author Alves
 */

@Service("pontoDataHoraService")
public class PontoDataHoraServiceImpl implements PontoDataHoraService {

	@Autowired
	private PontoHoraRepository pontoHoraRepository;
	@Autowired
	private PontoDataRepository pontoDataRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userService;

	@Override
	public boolean baterPonto(String matricula, String password) {

		if (verificarUserESenha(matricula, password)) {

			LocalDate data = LocalDate.now();
			DateTimeFormatter fomatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			data.format(fomatterDate);

			LocalTime time = LocalTime.now();
			DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");
			time.format(formatterHour);

			PontoData pdata = new PontoData();
			PontoHora phora = new PontoHora();
			
			User user = userService.findByMatriculaAndPasswordOne(matricula, password);
			
			phora.setHora(time);
			phora.getDia().setDia(data);
			pdata.setDia(data);
			pdata.getHora().add(phora);
			pdata.getUsers().getPonto().add(pdata);
			user.getPonto().add(pdata);
			
			userRepository.save(user);
			pontoDataRepository.save(pdata);
			pontoHoraRepository.save(phora);
			
			

		}

		return true;
	}

	private Boolean verificarUserESenha(String matricula, String password) {

		// TODO

		return false;
	}

	private Boolean verificarPontosRepetidos() {

		// TODO

		return false;
	}

	// =======================================================================================
	// Métodos posteriores para serem implementados
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
