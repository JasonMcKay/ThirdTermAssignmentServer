package com.restful_server.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class App {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(App.class, args);
	}
}
