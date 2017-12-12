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
	private int minTrabalhados;
	

	//Construtores --------------------------
	public DiaComHoras() {

	}
	public DiaComHoras(String dia, String hora, int minTrabalhados) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.minTrabalhados = minTrabalhados; 
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
	public int getMinTrabalhados() {
		return minTrabalhados;
	}
	public void setMinTrabalhados(int minTrabalhados) {
		this.minTrabalhados = minTrabalhados;
	}

	// To String ------------------------------
	@Override
	public String toString() {
		return "DiaComHoras [dia=" + dia + ", hora=" + hora + "]";
	}
}