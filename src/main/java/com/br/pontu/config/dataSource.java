package com.br.pontu.config;

import java.io.FileInputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Robson
 */
@Configuration
public class dataSource {

	@Bean
	public DataSource dataSrc() {

		Properties props = new Properties();
		FileInputStream arquivo = null;
		String so = System.getProperty("os.name").toLowerCase();

		try {

			if (so.equalsIgnoreCase("windows 10") || so.equalsIgnoreCase("windows 7")) {

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

		dataSource.setDriverClassName(props.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(props.getProperty("spring.datasource.url"));
		dataSource.setUsername(props.getProperty("spring.datasource.username"));
		dataSource.setPassword(props.getProperty("spring.datasource.password"));

		return dataSource;

	}
}
