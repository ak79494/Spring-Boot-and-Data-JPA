package com.arun.spring_boot_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.arun.spring_boot_demo1.model.jpaRepo;

import jakarta.servlet.http.Cookie;

@SpringBootApplication
public class SpringBootWebappEComAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebappEComAppApplication.class, args);
		
		
	}

}
