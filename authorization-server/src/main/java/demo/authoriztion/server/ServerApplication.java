package demo.authoriztion.server;

import demo.authoriztion.server.spring.AuthorizationServerConfig;
import demo.authoriztion.server.spring.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("demo.authoriztion.server")
@EnableJpaRepositories("demo.authoriztion.server")
@EntityScan("demo.authoriztion.server.web.model")
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				ServerApplication.class,
				AuthorizationServerConfig.class,
				SecurityConfig.class}, args);
	}
}
