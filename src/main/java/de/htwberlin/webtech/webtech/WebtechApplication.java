package de.htwberlin.webtech.webtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebtechApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WebtechApplication.class, args);
		System.out.println("hello spring boot");
		Laptop laptop = context.getBean(Laptop.class);
		laptop.setId(1);
		laptop.setBrand("Apple");
		laptop.setModel("Macbook Pro 2022 Late");
		Alien a = context.getBean(Alien.class);

		a.show();



	}

}
