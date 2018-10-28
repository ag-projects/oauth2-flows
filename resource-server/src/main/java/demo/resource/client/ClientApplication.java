package demo.resource.client;

import demo.resource.client.spring.ResourceServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("demo.resource.client")
@EnableJpaRepositories("demo.resource.client")
@EntityScan("demo.resource.client.web.model")
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				ClientApplication.class,
				ResourceServerConfig.class}, args);
	}
}
