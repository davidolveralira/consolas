package com.amazon.videogames.consols;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ConsolasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsolasApplication.class, args);
	}

}
