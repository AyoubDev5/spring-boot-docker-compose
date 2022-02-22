package com.restapi.springbootdockercompose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication(scanBasePackages={
		"com.example.something", "com.example.application"})
public class SpringBootDockerComposeApplication {

	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		return sessionFactory;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerComposeApplication.class, args);
	}

}
