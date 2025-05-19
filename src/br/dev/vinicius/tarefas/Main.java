package br.dev.vinicius.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.dev.vinicius.tarefas.model.Funcionario;

public class Main {

	private static String path = "c:\\Users\\25132898\\ProjetoTarefas\\tarefas.txt";

	public static void main(String[] args) {
		
		Funcionario funcionario1 = new Funcionario("Maria da Silva");
		Funcionario funcionario2 = new Funcionario();
		Funcionario funcionario3 = new Funcionario("Programador", "Maria");
		Funcionario funcionario4 = new Funcionario("Programador", "Pedro", 2);
		
		System.out.println(funcionario1);
		System.out.println(funcionario2);
		System.out.println(funcionario3);
		System.out.println(funcionario4);

	}

	private static void gravarArquivo() {

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(path, true);
			bw = new BufferedWriter(fw);

			String novaLinha = "Isso é uma nova linha!!\n";

			bw.write(novaLinha);
			bw.flush();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}

	}

	private static void lerArquivo() {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String linha = br.readLine();
//			String registro[] = linha.split(";");
//			System.out.println("Nome: " + registro[0]);

			while (linha != null) {
				String registro[] = linha.split(";");
				System.out.println("Nome: " + registro[0]);
				System.out.println("Tarefa: " + registro[1]);
				
				linha = br.readLine();
			}

		} catch (FileNotFoundException erro) {
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

}
