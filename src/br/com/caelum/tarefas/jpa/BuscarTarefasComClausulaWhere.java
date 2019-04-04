package br.com.caelum.tarefas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.caelum.tarefas.Tarefa;

public class BuscarTarefasComClausulaWhere {

	public static void main(String[] args) {
		
		EntityManager manager = Persistence.createEntityManagerFactory("tarefas").createEntityManager();
		
		List<Tarefa> lista = manager.createQuery("select t from Tarefa as t where t.finalizado = false").getResultList();
		
		for(Tarefa tarefa : lista) {
			System.out.println(tarefa.getDescricao());
		}
	}

}
