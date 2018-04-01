/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.security;

import com.br.pontu.entity.User;
import com.br.pontu.services.UserServiceImpl;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Robson
 */
@Component
public class AuthProviderService implements AuthenticationProvider {

	@Autowired
	private UserServiceImpl userService;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login = auth.getName();
		String senha = auth.getCredentials().toString();

		try {
			senha = userService.encodePassword(senha);
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(AuthProviderService.class.getName()).log(Level.SEVERE, null, ex);
		}

		List<User> users = this.userService.findByMatriculaAndPassword(login, senha);

		if (users.isEmpty()) {

			throw new UsernameNotFoundException("Login e/ou Senha inválidos.");

		} else {
			final User user = users.get(0);
			GrantedAuthority autorizacao = new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return user.getAcesso().toString();
				}
			};
			ArrayList<GrantedAuthority> autorizacoes = new ArrayList<>();
			autorizacoes.add(autorizacao);
			// System.out.println(user.getRole().toString());
			return new UsernamePasswordAuthenticationToken(user.getMatricula(), user.getPassword(), autorizacoes);
		}
	}

	@Override
	public boolean supports(Class<?> type) {
		return type.equals(UsernamePasswordAuthenticationToken.class);
	}

}
