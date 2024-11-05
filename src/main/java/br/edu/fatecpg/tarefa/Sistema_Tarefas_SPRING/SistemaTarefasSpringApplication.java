package br.edu.fatecpg.tarefa.Sistema_Tarefas_SPRING;

import br.edu.fatecpg.tarefa.Sistema_Tarefas_SPRING.service.ListaTarefas;
import br.edu.fatecpg.tarefa.Sistema_Tarefas_SPRING.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SistemaTarefasSpringApplication implements CommandLineRunner {
	@Autowired
	private ListaTarefas listaTarefas;
	public static void main(String[] args) {
		SpringApplication.run(SistemaTarefasSpringApplication.class, args);
	}

	@Override
	public void run(String... args){
		//Tarefa tarefa = new Tarefa("Teste2" ,"Descricao", 1, "Feito", "Eu Mesmo" );
		//listaTarefas.addTarefa(tarefa);

		//Query Nativa
		int contarTarefas = listaTarefas.contarPorStatus("Feito");
		System.out.println(contarTarefas);

		//JPQL
		List<Tarefa> tarefasOrdenadas = listaTarefas.listarOrdenadoPorPrioridade();
		tarefasOrdenadas.forEach(System.out::println);

		List<Tarefa> responsaveis = listaTarefas.filtrarPorResponsavel("Eu Mesmo");
		System.out.println(responsaveis);
	}
}