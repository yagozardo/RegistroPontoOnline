package com.br.pontu.config;

/**
 * 
 * @author Alves
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class DAO {

	@Autowired
	private dataSource dataSource;
	
	@Bean
	// Resposável por criar conexão com o SGBD
	public Connection getConnection() {
		
		DriverManagerDataSource data = (DriverManagerDataSource) dataSource.dataSrc();

		Connection con = null;

		try {
			
			con = (Connection) DriverManager.getConnection(data.getUrl(), data.getUsername(), data.getPassword());
			
		} catch (SQLException ex) {
		}
		
		return con;
	}
	
}
