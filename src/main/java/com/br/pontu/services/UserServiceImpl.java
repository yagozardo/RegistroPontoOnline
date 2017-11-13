/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pontu.entity.User;
import com.br.pontu.repositories.UserRepository;

/**
 *
 * @author Robson
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@PersistenceContext
	private EntityManager manager;

	@Override
	public User cadastrarUsuario(User user) {
		long mat = (long) (Math.random() * 2000);
		System.out.println("MATRICULA GERADA ---------> " + mat);
		user.setMatricula(String.valueOf(mat));
		String encrypt = String.valueOf(mat);
		System.out.println("SENHA ANTES DE ENCRIPTAR ----------> " + encrypt);
		try {
			encrypt = encodePassword(encrypt);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		System.out.println("SENHA APÓS ENCRIPTAR ----------> " + encrypt);

		user.setPassword(encrypt);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		Iterable<User> itr = userRepository.findAll();
		return (List<User>) itr;
	}

	@Override
	public void deletarUsuario(long id) {

		userRepository.delete(id);
	}

	@Override
	public User findById(long id) {
		return userRepository.getOne(id);
	}

	@SuppressWarnings("restriction")
	public String encodePassword(String senha) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(senha.getBytes());
		return new sun.misc.BASE64Encoder().encode(md.digest());

	}

	@Override
	public List<User> findByMatriculaAndPassword(String matricula, String password) {
		return userRepository.findByMatriculaAndPassword(matricula, password);
	}

	
	// ============================================================================================
	// Função para para Bater Ponto INICIO
	public List<User> findByMatricula(String matricula) {

		// Criando criteria do JPA
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);

		// Incluindo predicados.
		Predicate[] predicates = criarRestricoes(matricula, builder, root);
		criteria.where(predicates);

		// Conclusão da query
		TypedQuery<User> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	// Função que cria os predicados
	private Predicate[] criarRestricoes(String matricula, CriteriaBuilder builder, Root<User> root) {

		// Criando lista de predicados
		List<Predicate> predicates = new ArrayList<>();

		predicates.add(builder.like(builder.lower(root.get("matricula")), matricula.toLowerCase()));

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	// Função para para Bater Ponto FIM
	// ================================================================================================

}
