/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.security;

import com.br.pontu.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Robson
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthProviderService authProvider;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
               

//                .antMatchers("/admin/registro").permitAll()
                .antMatchers("/admin/**").hasAuthority(Role.Admin.toString())
                .antMatchers("/espelho/**").hasAnyAuthority(Role.Admin.toString(), Role.User.toString())

                .antMatchers("/admin/registro").permitAll()
//                .antMatchers("/admin/**").hasAuthority(Role.Admin.toString())

                .antMatchers("/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("matricula")
                .passwordParameter("password")
                .defaultSuccessUrl("/admin/menu");
    }

}
