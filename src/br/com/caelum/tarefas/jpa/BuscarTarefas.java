package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.caelum.tarefas.Tarefa;

public class BuscarTarefas {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();		
		
		Query query = manager.createQuery("select t from Tarefa as t where t.finalizado = :paramFinalizado");
		query.setParameter("paramFinalizado", false);

		List<Tarefa> lista = query.getResultList();
		
		for(Tarefa tarefa : lista) {
			System.out.println(tarefa.getDescricao());
		}
	}

}
