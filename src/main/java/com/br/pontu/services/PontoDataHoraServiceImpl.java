package com.br.pontu.services;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pontu.config.DAO;
import com.br.pontu.entity.DiaComHoras;
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

	// Injeções
	@Autowired
	private PontoHoraRepository pontoHoraRepository;
	@Autowired
	private PontoDataRepository pontoDataRepository;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private DAO dao;
	@Autowired
	private UserRepository userRepository;

	// Função resposável por bater ponto, garantir unicidade e conscistência do
	// banco.
	@Override
	public boolean baterPonto(String matricula, String password) {

		List<User> users = userService.findByMatricula(matricula);

		// Condição para caso não tenha encontrado nada no banco
		if (users.size() == 0 || matricula.isEmpty() || password.isEmpty()) {

			return false;
		}

		User user = users.get(0);

		if (verificarUserESenha(matricula, password, user)) {

			// Pega a data e formata
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Calendar dia = null;
			dia = Calendar.getInstance();
			String diaFormatado = dateFormat.format(dia.getTime());

			// Pega as horas e formata
			DateFormat hourFormat = new SimpleDateFormat("HH:mm");
			Calendar hour = null;
			hour = Calendar.getInstance();
			String horaFormatado = hourFormat.format(hour.getTime());

			// Cria Instancias de PontoData e PontoHora
			PontoData pdata = new PontoData();
			PontoHora phora = new PontoHora();

			// Garante apenas uma data por usuário
			Long dia_id = verificarDiaExistente(diaFormatado, user.getId());

			//
			if (dia_id != null) {

				if (!verificarPontosRepetidos(dia_id, horaFormatado)) {

					// Salva a hora, e o ID do dia correspondente
					phora.setHora(horaFormatado);
					phora.setDataId(dia_id);
					pontoHoraRepository.save(phora);

					pdata = pontoDataRepository.findOne(dia_id);
					pdata.getHoras().add(phora);
					pdata = pontoDataRepository.save(pdata);

				}

				return true;

			} else {

				// Salva o dia com a data, e o ID do usuário
				pdata.setDia(diaFormatado);
				pdata.setUserId(user.getId());
				pdata = pontoDataRepository.save(pdata);

				// Vincula a data ao usuário
				user.getPonto().add(pdata);
				userRepository.save(user);

				// Salva a hora, e o ID do dia correspondente
				phora.setHora(horaFormatado);
				phora.setDataId(pdata.getId());
				phora = pontoHoraRepository.save(phora);

				// Vincula a hora a data
				List<PontoHora> hora = new ArrayList<>(); // Como será o primeiro horário desse dia, criar arraylist
															// para não ocorrer null pointer.
				hora.add(phora);
				pdata.setHoras(hora);
				pontoDataRepository.save(pdata);

				return true;

			}
		}

		return false;
	}

	// Função que verifica se já existe aquela data salva no banco
	// caso exista = Retorna ID do dia
	// caso contrário = Retorna null
	private Long verificarDiaExistente(String diaFormatado, Long userId) {

		List<PontoData> datas = pontoDataRepository.findByUserId(userId, diaFormatado);

		for (int i = 0; i < datas.size(); i++) {

			if (diaFormatado.equals(datas.get(i).getDia()) && datas.get(i).getUserId().equals(userId)) {

				return datas.get(i).getId();
			}
		}

		return null;
	}

	// Função que checa se o Usuário buscado do banco, tenha a matricula e a senha
	// iguais as do banco.
	private Boolean verificarUserESenha(String matricula, String password, User user) {

		try {

			// Encripta se a senha recebida para comparar com a do banco
			String passwordEncode = userService.encodePassword(password);

			// Checa se ambos tanto a matricula, quanto o password é o mesmo do banco
			if (matricula.equals(user.getMatricula()) && passwordEncode.equals(user.getPassword())) {

				return true;
			}

			return false;

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return false;
	}

	// Return true: se houver pontos repetidos
	// Return false: não houver pontos repetidos
	private Boolean verificarPontosRepetidos(Long dia_id, String horaFormatado) {

		List<String> horarios = pontoHoraRepository.findByDayId(dia_id);

		// Variável que permite desconsiderar pontos batidos nesse intervalo de tempo
		int temporizador = 3;

		int horBanco = 0, horFormat = 0;
		int minBanco = 0, minFormat = 0;

		// Formata horas e min atuais
		horFormat = Integer.parseInt(horaFormatado.substring(0, 2));
		minFormat = Integer.parseInt(horaFormatado.substring(3));
		// Converte tudo para minutos
		minFormat = minFormat + (horFormat * 60);

		for (int i = 0; i < horarios.size(); i++) {

			// Formata horas e min vindos do banco
			minBanco = Integer.parseInt(horarios.get(i).substring(3));
			horBanco = Integer.parseInt(horarios.get(i).substring(0, 2));
			minBanco = minBanco + (horBanco * 60);

			// Faz uma subtração e checa com o temporizador
			if ((minFormat - minBanco) <= temporizador) {

				return true;
			}
		}

		return false;
	}

	// Função que retorna os dias com horários de um determinado usuário
	@Override
	public List<DiaComHoras> buscar30Dias(Long userId) {

		String dataAnterior = null, dataAtual = null;
		int qDias = 30;

		// Pega a data e formata
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar dia = null;
		dia = Calendar.getInstance();
		dataAtual = dateFormat.format(dia.getTime());

		// Pega a data e subtrai 30 dias
		dia = Calendar.getInstance();
		dia.add(Calendar.DATE, -qDias);
		dataAnterior = dateFormat.format(dia.getTime());

		// Query para select ao banco
		String sql = "SELECT dia, hora FROM ponto_data INNER JOIN ponto_hora ON ponto_data.id = ponto_hora.data_id "
				+ "WHERE ponto_data.user_id = '" + userId + "' AND (ponto_data.dia BETWEEN '" + dataAnterior + "' AND '"
				+ dataAtual + "');";

		try {

			// Instacia lista da Classe utilitária DiaComHoras
			List<DiaComHoras> listaDiasComHoras = new ArrayList<>();

			// Cria conexão com o SBGD e realiza a consulta
			Connection conn = dao.getConnection();
			java.sql.PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			// Loop para extrair todas as tuplas
			while (rs.next()) {

				DiaComHoras aux = new DiaComHoras();

				aux.setDia(rs.getString("dia"));
				aux.setHora(rs.getString("hora"));

				listaDiasComHoras.add(aux);
			}

			return listaDiasComHoras;

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		// Por defult caso encotre algum erro
		return null;
	}

	@Override
	public List<DiaComHoras> mesSelecionado(Long userId, String mes, int ano) {

		// Variáveis
		String dataInicio = null, dataFim = null;
		int lenght = 0, i = 0;
		// Instacia lista da Classe utilitária DiaComHoras
		List<DiaComHoras> listaDiasComHoras = new ArrayList<>();

		if ("01".equals(mes) || "03".equals(mes) || "05".equals(mes) || "07".equals(mes) || "08".equals(mes)
				|| "10".equals(mes) || "12".equals(mes)) { // Para meses que tem até o dia 31

			dataInicio = ano + "/" + mes + "/01";
			dataFim = ano + "/" + mes + "/31";
			lenght = 31;

		} else if ("02".equals(mes)) { // Verificação para fevereiro - mês 02

			if (ano == 2020 || ano == 2024) { // TODO aplicar regra divisivel por 4 nas dezenas

				dataInicio = ano + "/" + mes + "/01";
				dataFim = ano + "/" + mes + "/29";
				lenght = 29;

			} else {

				dataInicio = ano + "/" + mes + "/01";
				dataFim = ano + "/" + mes + "/28";
				lenght = 28;

			}

		} else if ("04".equals(mes) || "06".equals(mes) || "09".equals(mes) || "11".equals(mes)) { // Verificação para
																									// meses com 30
																									// dias.

			dataInicio = ano + "/" + mes + "/01";
			dataFim = ano + "/" + mes + "/30";
			lenght = 30;

		} else {

			return null; // TODO fazer validação de mês inválido.
		}

		// Preencher a lista com os dados
		for (i = 1; i <= lenght; i++) {

			DiaComHoras dia = new DiaComHoras();
			String data;

			if (i < 10) {

				data = ano + "/" + mes + "/0" + i;

			} else {

				data = ano + "/" + mes + "/" + i;
			}

			dia.setDia(data);

			listaDiasComHoras.add(dia);

		}

		// Query para select ao banco
		String sql = "SELECT dia, min_trabalhados, hora FROM ponto_data INNER JOIN ponto_hora ON ponto_data.id = ponto_hora.data_id "
				+ "WHERE ponto_data.user_id = '" + userId + "' AND (ponto_data.dia BETWEEN '" + dataInicio + "' AND '"
				+ dataFim + "');";

		try {

			// Cria conexão com o SBGD e realiza a consulta
			Connection conn = dao.getConnection();
			java.sql.PreparedStatement p = conn.prepareStatement(sql);
			ResultSet rs = p.executeQuery();

			// Loop para extrair todas as tuplas
			while (rs.next()) {

				for (i = 0; i < lenght; i++) {

					if (listaDiasComHoras.get(i).getDia().equals(rs.getString("dia"))) {

						if (listaDiasComHoras.get(i).getHora() != null) {

							listaDiasComHoras.get(i)
									.setHora(listaDiasComHoras.get(i).getHora() + " - " + rs.getString("hora"));

						} else {

							listaDiasComHoras.get(i).setHora(rs.getString("hora"));

							String hsContabilizadas = hsContabilizadas(rs.getInt("min_trabalhados"), userId);
							listaDiasComHoras.get(i).setMinTrabalhados(hsContabilizadas);
						}
					}
				}
			}

			return listaDiasComHoras;

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		return null;
	}

	
	//Função que recebe a quantidade de minutos trabalhados e retorna o saldo do dia
	//Seja ele positivo, negativo ou nulo.
	private String hsContabilizadas(int minTrabalhados, Long userId) {

		int horas = 0, minRestantes = 0;
		User user = userRepository.findOne(userId);
		String contabilizados;
		
		minRestantes = (minTrabalhados - user.getCargaHoraria() * 60);

		if (minRestantes == 0) {

			contabilizados = "+ 00:00";

		} else if (minRestantes > 0) {

			while(minRestantes >= 60) {

				horas = horas + 1;
				minRestantes = minRestantes - 60;
			}

			if (horas < 10 && minRestantes < 10) {

				contabilizados = "+ 0" + horas + ":0" + minRestantes;

			} else if (horas < 10 && minRestantes >= 10) {

				contabilizados = "+ 0" + horas + ":" + minRestantes;

			} else if (horas >= 10 && minRestantes < 10) {

				contabilizados = "+ " + horas + ":0" + minRestantes;

			} else {

				contabilizados = "+ " + horas + ":" + minRestantes;
			}

		} else { // Validações p/ tempo negativo.

			minRestantes = minRestantes * (-1);
			
			while (minRestantes >= 60) {

				horas = horas + 1;
				minRestantes = minRestantes - 60;
			}

			if (horas < 10 && minRestantes < 10) {

				contabilizados = "- 0" + horas + ":0" + minRestantes;

			} else if (horas < 10 && minRestantes >= 10) {

				contabilizados = "- 0" + horas + ":" + minRestantes;

			} else if (horas >= 10 && minRestantes < 10) {

				contabilizados = "- " + horas + ":0" + minRestantes;

			} else {

				contabilizados = "- " + horas + ":" + minRestantes;
			}
		}

		return contabilizados;
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
