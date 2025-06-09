package br.dev.vinicius.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private String arquivo = "C:\\Users\\25132898\\ProjetoTarefas\\funcionarios.csv";
	private String tarefa = "C:\\Users\\25132898\\ProjetoTarefas\\tarefas.csv";

	private FileWriter fwArquivo;
	private FileWriter fwTarefas;
	
	private BufferedWriter bwArquivo;
	private BufferedWriter bwTarefas;

	private FileReader frArquivo;
	private FileReader frTarefas;
	
	private BufferedReader brArquivo;
	private BufferedReader brTarefas;

	public FileFactory() throws IOException {

		// Necessário para escrever no arquivo
		fwArquivo = new FileWriter(arquivo, true);
		bwArquivo = new BufferedWriter(fwArquivo);

		// Necessário para ler arquivo
		frArquivo = new FileReader(arquivo);
		brArquivo = new BufferedReader(frArquivo);
		
		fwTarefas = new FileWriter(tarefa, true);
		bwTarefas = new BufferedWriter(fwTarefas);

		// Necessário para ler arquivo
		frTarefas = new FileReader(tarefa);
		brTarefas = new BufferedReader(frTarefas);
	}


	public BufferedWriter getBufferedWriterArquivo() {

		return bwArquivo;
	}

	public BufferedReader getBufferdReaderArquivo() {
		return brArquivo;
	}
	
	public BufferedWriter getBufferedWriterTarefas() {

		return bwTarefas;
	}
	
	public BufferedReader getBufferdReaderTarefas() {
		return brArquivo;
	}
}
