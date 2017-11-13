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

        try {

            arquivo = new FileInputStream("C:\\Pontu\\datasource.properties");
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

