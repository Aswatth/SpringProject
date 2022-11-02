package springLiquibase;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringLiquibaseApplication {

	public static void main(String[] args) {		
		SpringApplication.run(SpringLiquibaseApplication.class, args);
	}

}
