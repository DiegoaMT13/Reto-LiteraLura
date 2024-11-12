package com.aluracursos.literaLura;

import com.aluracursos.literaLura.principal.Principal;
import com.aluracursos.literaLura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraLuraApplication implements CommandLineRunner {

@Autowired
private LibroRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraLuraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraMenu();
	}
}
