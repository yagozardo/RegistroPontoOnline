/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.pontu.config;

/**
 *
 * @author Robson
 */
import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author sltnote-6354
 */
@Configuration
public class dataSource {

	@Bean
	public DataSource dataSrc() {

		Properties props = new Properties();
		FileInputStream arquivo = null;
		String so = System.getProperty("os.name").toLowerCase();

		try {
			
			
			if(so.equalsIgnoreCase("windows 10") || so.equalsIgnoreCase("windows 7")) {
					
				arquivo = new FileInputStream("C:\\Pontu\\datasource.properties");
			}
			if (so.equalsIgnoreCase("linux")) {

				arquivo = new FileInputStream("/usr/local/pontu/datasource.properties");
			}

			props.load(arquivo);

		} catch (Exception e) {
			System.out.println("ERRO " + e);
		}

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/usuariodb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;

	}

}
