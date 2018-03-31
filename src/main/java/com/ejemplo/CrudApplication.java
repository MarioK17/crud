package com.ejemplo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ejemplo.bean.Producto;
import com.ejemplo.repositorio.ProductoRepository;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ProductoRepository repository) {
        return args -> {

        	repository.save(new Producto("Gorra", "Gorra Roja", 14.3));
        	repository.save(new Producto("Zapatilla", "Zapatilla Azul", 142.3));
        	repository.save(new Producto("Polo", "Polo Blanco", 42.2));

            

        };
    }
}
