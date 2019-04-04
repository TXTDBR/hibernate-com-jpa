package br.com.caelum.tarefas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.Tarefa;

public class AtualizarTarefa {

	public static void main(String[] args) {

		Tarefa tarefa = new Tarefa();
		tarefa.setId(3L);
		tarefa.setDescricao("Estudar HTML e CSS");
		tarefa.setFinalizado(false);
		tarefa.setDataFinalizacao(null);
		
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		manager.close();
		

	}

}
