package com.br.pontu.services;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pontu.entity.PontoData;
import com.br.pontu.entity.PontoHora;
import com.br.pontu.entity.User;
import com.br.pontu.repositories.PontoDataRepository;
import com.br.pontu.repositories.PontoHoraRepository;

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
	private UserServiceImpl userService;

	@Override
	public boolean baterPonto(String matricula, String password) {

		List<User> users = userService.findByMatricula(matricula);

		User user = users.get(0);

		if (verificarUserESenha(matricula, password, user)) {

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		    Calendar dia = null;
		    dia = Calendar.getInstance();
		    String diaFormatado = dateFormat.format(dia.getTime());

		    DateFormat hourFormat = new SimpleDateFormat("HH:mm");
		    Calendar hour = null;
		    hour = Calendar.getInstance();
		    String horaFormatado = hourFormat.format(hour.getTime());
	

//			LocalDate data = LocalDate.now();
//			DateTimeFormatter fomatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			data.format(fomatterDate);
//
//			LocalTime time = LocalTime.now();
//			DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm");
//			time.format(formatterHour);

			PontoData pdata = new PontoData();
			PontoHora phora = new PontoHora();

			
			
			
			pdata.setDia(diaFormatado);
			pdata.setUserId(user.getId());
			
			pdata = pontoDataRepository.save(pdata);
			System.out.println("\n\n\nSalvou Data\n\n\n");
			
			phora.setHora(horaFormatado);
			phora.setDataId(pdata.getId());

			pontoHoraRepository.save(phora);
			System.out.println("\\n\\n\\nSalvou Hora\n\n\n");
			
			return true;
			
		}

		return true;
	}

	// Função que checa se o Usuário buscado do banco, tenha a matricula e a senha
	// iguais as do banco.
	private Boolean verificarUserESenha(String matricula, String password, User user) {

		try {

			String passwordEncode = userService.encodePassword(password);
			
			System.out.println(passwordEncode);

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
