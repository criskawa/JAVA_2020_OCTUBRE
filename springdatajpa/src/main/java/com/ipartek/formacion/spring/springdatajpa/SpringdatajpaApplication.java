package com.ipartek.formacion.spring.springdatajpa;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ipartek.formacion.spring.springdatajpa.entidades.Cliente;
import com.ipartek.formacion.spring.springdatajpa.repositorios.ClienteRepository;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class SpringdatajpaApplication { //implements CommandLineRunner {

//	@Autowired
//	private ClienteRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(repo);
//	}
	
	@Bean
	CommandLineRunner prueba(ClienteRepository repo) {
		return (args) -> {
		      repo.save(new Cliente(null, "Kim", "Bauer"));
		      repo.save(new Cliente(null, "Chloe", "O'Brian"));
		      repo.save(new Cliente(null, "Jack", "Bauer"));
		      repo.save(new Cliente(null, "David", "Palmer"));
		      repo.save(new Cliente(null, "Michelle", "Dessler"));
		      
		      repo.deleteById(4L);
		      
		      for(Cliente c: repo.findAll()) {
		    	  log.info(c.toString());
		      }
		      
		      Optional<Cliente> cliente = repo.findById(3L);
		      
		      cliente.ifPresent(c -> log.info(c.toString()));
		      
		      log.info(cliente.orElse(new Cliente(null, "Desconocido", "Desconocidez")).toString());
		      
		      for(Cliente c: repo.findByApellidos("Bauer")) {
		    	  log.info(c.toString());
		      }
		      
		      log.info(repo.findIdByNombreApellidos("Kim", "Bauer").toString());
		      
		      for(Cliente c: repo.findAll(PageRequest.of(1, 2, Sort.by("nombre")))) {
		    	  log.info(c.toString());
		      }
		      
		      for(Cliente c: repo.findAll(Sort.by("apellidos","nombre"))) {
		    	  log.info(c.toString());
		      }
		};
	}

}
