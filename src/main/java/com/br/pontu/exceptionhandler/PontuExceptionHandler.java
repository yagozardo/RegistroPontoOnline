package com.br.pontu.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Está classe será responsável por informar o usuário caso haja 
 * algum tipo validação feita em 'Cliente-Side' não seja bem sucedida.
 * 
 * @since 19/10/2017
 * @author Alves
 */


//Anotação de efeito global.
@ControllerAdvice
public class PontuExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	
	
	
	
	
	
	
	/**
	 * Classe estática responsável apenas pela construção da mensagem de 
	 * retorno para o usuário. Ela precisa de 2 paramêtros:
	 * Mensagem para o usuário - mensagem clara. 
	 * Mensagem para o desenvolvedor - erro de console.
	 * 
	 * @author Alves
	 */
	public static class Error {

		// Attributes -------------------------
		private String msgUser;
		private String msgDevelop;

		// Constuctor -------------------------
		public Error(String msgUser, String msgDevelop) {
			super();
			this.msgUser = msgUser;
			this.msgDevelop = msgDevelop;
		}

		// Getters and Setters ----------------
		public String getMsgUser() {
			return msgUser;
		}

		public void setMsgUser(String msgUser) {
			this.msgUser = msgUser;
		}

		public String getMsgDevelop() {
			return msgDevelop;
		}

		public void setMsgDevelop(String msgDevelop) {
			this.msgDevelop = msgDevelop;
		}
	}

}
