package com.br.pontu.exception.exceptionhandler;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe de erro personalizado seguindo metricas do framework
 * 
 * @author alves
 *
 */
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos ------------------------------------
	@JsonFormat(pattern = "dd/MM/yy hh:mm")
	private Date timesTamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	// Contructor ------------------------------------
	public StandardError() {
	}
	public StandardError(Long timesTamp, Integer status, String error, String message, String path) {
		super();
		this.timesTamp = new Date(timesTamp);
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}


	// Getters and Setters -------------------------------
	public Date getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Date timesTamp) {
		this.timesTamp = timesTamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
