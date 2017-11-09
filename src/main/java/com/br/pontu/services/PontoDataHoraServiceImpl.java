package com.br.pontu.services;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    // Injeções
    @Autowired
    private PontoHoraRepository pontoHoraRepository;
    @Autowired
    private PontoDataRepository pontoDataRepository;
    @Autowired
    private UserServiceImpl userService;

    // Função resposável por bater ponto, garantir unicidade e conscistência do
    // banco.
    @Override
    public boolean baterPonto(String matricula, String password) {

        List<User> users = userService.findByMatricula(matricula);
        User user = users.get(0);

        if (verificarUserESenha(matricula, password, user)) {

            // Pega a data e formata
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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

                }

                return true;

            } else {

                // Salva o dia com a data, e o ID do usuário
                pdata.setDia(diaFormatado);
                pdata.setUserId(user.getId());
                pdata = pontoDataRepository.save(pdata);

                // Salva a hora, e o ID do dia correspondente
                phora.setHora(horaFormatado);
                phora.setDataId(pdata.getId());
                pontoHoraRepository.save(phora);

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

    @Override
    public void buscar30Dias(String matricula) {

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

    @Override
    public void buscar60Dias() {
        // TODO Auto-generated method stub

    }

    @Override
    public void buscar90Dias() {
        // TODO Auto-generated method stub

    }

    //Classe utilitária para fazer composição dos dias com as horas de um  determinado usuário
    public class diaComHoras {

        // Atributos
        private String cDia;
        private String cHora;

        diaComHoras(String cDia, String cHora) {

            this.cDia = cDia;
            this.cHora = cHora;
        }

        // Getters and setters ---------------
        public String getcDia() {
            return cDia;
        }
        public void setcDia(String cDia) {
            this.cDia = cDia;
        }
        public String getcHora() {
            return cHora;
        }
        public void setcHora(String cHora) {
            this.cHora = cHora;
        }

    }

}
