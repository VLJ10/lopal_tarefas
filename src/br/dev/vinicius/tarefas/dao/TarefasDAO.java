package br.dev.vinicius.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.dev.vinicius.tarefas.factory.FileFactory;
import br.dev.vinicius.tarefas.model.Tarefas;

public class TarefasDAO {
	private Tarefas tarefas;
	
	
	public TarefasDAO() {
	}
	
	public TarefasDAO(Tarefas tarefas) {
		this.tarefas = tarefas;
	}
	
	public void gravar() {
		
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriterTarefas().write(tarefas.toString());
			ff.getBufferedWriterTarefas().flush();
			System.out.println("Tarefas Gravada");
		}catch(IOException erro) {
			erro.printStackTrace();
		}
	}
	
	public List<Tarefas> listar() {
		List<Tarefas> tarefas = new ArrayList<Tarefas>();
		
		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferdReaderTarefas();
			
			String linha = "";
			
			br.readLine();
			
			while (linha != null) {
				
				linha = br.readLine();
				
				if (linha != null) {
					String tarefasStr[] = linha.split(",");
					
					Tarefas tarefa = new Tarefas();
					tarefa.setTitulo(tarefasStr[0]);
					tarefa.setDescrição(tarefasStr[1]);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					tarefa.setInicio(LocalDate.parse(tarefasStr[2], formatter));
					tarefa.setPrazo(Integer.parseInt(tarefasStr[3]));
					
					tarefas.add(tarefa);
					
				}
				
			}
			return tarefas;
		} catch (Exception erro) {
			erro.printStackTrace();
			return null;
		}
	}
	
}
