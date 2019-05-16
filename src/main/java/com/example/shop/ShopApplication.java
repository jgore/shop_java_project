package com.example.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ShopApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Test");
	}
}
