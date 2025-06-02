package br.dev.vinicius.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {
	
	private String arquivo = "C:\\Users\\25132898\\ProjetoTarefas\\funcionarios.csv";
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	private FileReader fr;
	private BufferedReader br;
	
	public FileFactory() throws IOException {
		
		// Necessário para escrever no arquivo
		fw = new FileWriter(arquivo, true);
		bw = new BufferedWriter(fw);
		
		//Necessário para ler arquivo
		fr = new FileReader(arquivo);
		br = new BufferedReader(fr);
	}
	
	public BufferedWriter getBufferedWriter () {
		
		return bw;
	}
	
	public BufferedReader getBufferdReader() {
		return br;
	}
	
}
