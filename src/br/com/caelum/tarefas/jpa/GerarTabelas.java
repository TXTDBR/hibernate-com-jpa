package br.com.caelum.tarefas.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.Tarefa;

public class GerarTabelas {

	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("Estudar JPA");
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		//grava objeto no bd
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa id: " + tarefa.getId());
		
		Tarefa encontrada = manager.find(Tarefa.class, 1L);
		
		System.out.println(encontrada.getDescricao());
		manager.close();
		factory.close();

	}

}
