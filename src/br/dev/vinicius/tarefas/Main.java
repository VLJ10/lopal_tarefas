package br.dev.vinicius.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.dao.TarefasDAO;
import br.dev.vinicius.tarefas.model.Funcionario;
import br.dev.vinicius.tarefas.model.Tarefas;
import br.dev.vinicius.tarefas.ui.FrameFuncionario;
import br.dev.vinicius.tarefas.ui.FrameFuncionarioList;
import br.dev.vinicius.tarefas.utils.Utils;

public class Main {

	private static String path = "c:\\Users\\25132898\\ProjetoTarefas\\tarefas.txt";

	public static void main(String[] args) {
		
		
		new Tarefas();
		
		
		
		
        
		Tarefas t = new Tarefas();
		t.setTitulo("Lave a Louça");
		t.setDescrição("Lava direito e seque");
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		t.setInicio(LocalDate.parse("10/10/2020" , formatter));
		t.setPrazo(3);
		
		TarefasDAO dao = new TarefasDAO(t); 
		dao.gravar();
		
		
		
//	    new FrameFuncionarioList();
//		new FrameFuncionario();
		
//		FuncionarioDAO dao = new FuncionarioDAO();
//		List<Funcionario> funcionarios = dao.listar();
//		
//		for(Funcionario f : funcionarios) {
//			System.out.println(f.getNome());
//			System.out.println(f.getCargo());
//			System.out.println("----------------");
//		}
		
//		Funcionario f = new Funcionario();
//		f.setNome("Zacarias");
//		f.setCargo("Zelador");
//		f.setSalario(1200.50);
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f);
//		dao.gravar();
	

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
