package com.example.demo;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.h2.tools.Server;
@SpringBootApplication
public class SpringSecurityEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityEmailApplication.class, args);
	}
}
