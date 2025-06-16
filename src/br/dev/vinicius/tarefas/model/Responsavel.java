package br.dev.vinicius.tarefas.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.factory.FileFactory;

public class Responsavel {
	
	
	
	String caminho = "C:\\Users\\25132898\\ProjetoTarefas\\funcionarios.csv";
	 public static List<String> Responsavel(String caminho) throws IOException {
	        List<String> nomes = new ArrayList<>();
	        
	        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
	            String linha;
	            while ((linha = reader.readLine()) != null) {
	                // Remove espaços em branco e adiciona se não estiver vazia
	                linha = linha.trim();
	                if (!linha.isEmpty()) {
	                    nomes.add(linha);
	                }
	            }
	        }
	        
	        return nomes;
	    }	

	
	
}
