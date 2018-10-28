package com.gharibi.clientcredentials;

import com.gharibi.clientcredentials.spring.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan("com.gharibi.clientcredentials")
@EnableJpaRepositories("com.gharibi.clientcredentials")
@EntityScan("com.gharibi.clientcredentials.web.model")
public class ClientcredentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				ClientcredentialsApplication.class,
				SecurityConfig.class}, args);
	}
}
