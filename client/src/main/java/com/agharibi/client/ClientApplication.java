package com.agharibi.client;

import com.agharibi.client.spring.AppMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.agharibi.client")
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				ClientApplication.class, AppMvcConfig.class}, args);
	}
}
