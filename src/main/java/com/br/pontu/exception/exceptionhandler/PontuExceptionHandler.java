package com.br.pontu.exception.exceptionhandler;

import java.sql.SQLException;

import javax.management.InvalidAttributeValueException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.pontu.exception.FileException;

/**
 * Está classe será responsável por informar o usuário caso haja algum tipo
 * validação feita em 'Cliente-Side' não seja bem sucedida.
 * 
 * @since 19/10/2017
 * @author Alves
 */

// Anotação de efeito global.
@ControllerAdvice
public class PontuExceptionHandler extends ResponseEntityExceptionHandler {

	// Trata dados que não foram encontrados
	// -------------------------------------------
	@ExceptionHandler({ ObjectNotFoundException.class })
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	// Trata erros genericos relacionados de acesso ao banco.
	// -------------------------------------------
	@ExceptionHandler({SQLException.class})
	public ResponseEntity<StandardError> sqlException(SQLException e, HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	// Trata exceções quando entidades vinculadas não foram encontradas
	// --------------------------------
	@org.springframework.web.bind.annotation.ExceptionHandler({ DataIntegrityViolationException.class })
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Integridade de dados", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	// Trata parametros com dados inválidos
	// ------------------------------------------------------------
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
				"Erro de validação", e.getMessage(), " ");

		for (FieldError erro : e.getBindingResult().getFieldErrors()) {

			error.setErros(new FieldMessage(erro.getField(), erro.getDefaultMessage()));
		}

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}

	// Trata exceções quando entidades vinculadas não foram encontradas
	// --------------------------------
	@ExceptionHandler({ InvalidAttributeValueException.class })
	public ResponseEntity<Object> InvalidAttributeValueException(InvalidAttributeValueException e,
			HttpServletRequest request, WebRequest res) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Dados inválidos", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	// Trata exceções quando existe permissão de acesso negada.
	// --------------------------------
	@ExceptionHandler({ AuthorizationServiceException.class })
	public ResponseEntity<Object> AuthorizationServiceException(AuthorizationServiceException e,
			HttpServletRequest request, WebRequest res) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
				"Acesso negado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}

	// Trata exceções quando existir erros na conversão de arquivo
	// --------------------------------
	@ExceptionHandler({ FileException.class })
	public ResponseEntity<Object> fileException(FileException e, HttpServletRequest request, WebRequest res) {

		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Erro de arquivo", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
