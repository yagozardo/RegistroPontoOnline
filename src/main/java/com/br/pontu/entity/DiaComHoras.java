package com.br.pontu.entity;

/**
 * 
 * @author Alves
 * @since 12/11/2017
 */

// Classe utilitária para fazer composição dos dias com as horas de um
// determinado usuário
public class DiaComHoras {

	// Atributos  -----------------------
	private String dia;
	private String hora;
	
	//Construtores --------------------------
	public DiaComHoras() {

	}
	public DiaComHoras(String dia, String hora) {
		super();
		this.dia = dia;
		this.hora = hora;
	}
	
	// Getters and setters ---------------
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	// To String ------------------------------
	@Override
	public String toString() {
		return "DiaComHoras [dia=" + dia + ", hora=" + hora + "]";
	}
}