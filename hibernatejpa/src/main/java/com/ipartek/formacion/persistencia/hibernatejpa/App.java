package com.ipartek.formacion.persistencia.hibernatejpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.formacion.persistencia.hibernatejpa.entidades.Cliente;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("com.ipartek.formacion.persistencia.hibernatejpa.entidades");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Cliente cliente = new Cliente(null, "Javier", LocalDate.now());
		
		System.out.println("Cliente ANTES del persist: " + cliente);
		
		em.persist(cliente);
		
		System.out.println("Cliente DESPUÉS del persist: " + cliente);
		
		cliente.setFechaNacimiento(LocalDate.of(1999, 1, 2));
		
		System.out.println("Cliente DESPUÉS de modificación: " + cliente);
		
		listar(em);

		em.getTransaction().commit();
		
		em.getTransaction().begin();
		
		cliente = new Cliente(5L, "Pepe", LocalDate.now());
		
		em.merge(cliente);
		
		listar(em);
		
		cliente = em.find(Cliente.class, 3L);
		
		System.out.println("Id 3 buscado" + cliente);
		
		//em.remove(cliente);
		
		cliente = em.createQuery("from Cliente c where c.nombre = 'Juan'", Cliente.class).getSingleResult();
		
		System.out.println(cliente);
		
		Long id = em.createQuery("select c.id from Cliente c where c.nombre = 'Juan'", Long.class).getSingleResult();
		
		System.out.println(id);
		
		@SuppressWarnings("unchecked")
		List<Cliente> clientes = em.createNativeQuery("SELECT * FROM clientes", Cliente.class).getResultList();
		
		for(Cliente c: clientes) {
			System.out.println(c);
		}
		
		em.getTransaction().commit();
	}

	private static void listar(EntityManager em) {
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
		
		for(Cliente c: clientes) {
			System.out.println(c);
		}
	}
}
