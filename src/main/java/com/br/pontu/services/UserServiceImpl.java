package com.br.pontu.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public User cadastrarUsuario(User user, boolean isNewUser) {
            if(isNewUser){
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
            }
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
}
