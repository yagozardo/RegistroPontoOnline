package com.br.pontu.services;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

		List<User> users = userService.findByMatricula(matricula);

		User user = users.get(0);

		if (verificarUserESenha(matricula, password, user)) {

			

			LocalDate data = LocalDate.now();
			DateTimeFormatter fomatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			data.format(fomatterDate);

			LocalTime time = LocalTime.now();
			DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");
			time.format(formatterHour);

			PontoData pdata = new PontoData();
			PontoHora phora = new PontoHora();
			List<PontoHora> lhora = new ArrayList<>();
			List<PontoData> ldata = new ArrayList<>();
			
			System.out.println("\n\n" + data + "\n" + time);
			
			phora.setHora(time);
			phora.setDia(pdata);
			pdata.setDia(data);
			
			lhora.add(phora);
			pdata.setHora(lhora);
		
			pdata.setUsers(user);
	
			ldata.add(pdata);
			user.setPonto(ldata);

			userRepository.save(user);
			pontoDataRepository.save(pdata);
			pontoHoraRepository.save(phora);

		}

		return true;
	}

	// Função que checa se o Usuário buscado do banco, tenha a matricula e a senha
	// iguais as do banco.
	private Boolean verificarUserESenha(String matricula, String password, User user) {

		try {

			String passwordEncode = userService.encodePassword(password);

			// Checa se ambos tanto a matricula, quanto o password é o mesmo do banco
			if (matricula.equals(user.getMatricula()) && passwordEncode.equals(user.getPassword())) {

				return true;
			}

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

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
