package com.bits.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.bits.movies"})
public class Application {
	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
		
	}

}