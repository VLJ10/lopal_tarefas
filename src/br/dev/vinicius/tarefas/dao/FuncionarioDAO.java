package br.dev.vinicius.tarefas.dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.vinicius.tarefas.factory.FileFactory;
import br.dev.vinicius.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	public FuncionarioDAO() {
	}

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferedWriter().write(funcionario.toString());
			ff.getBufferedWriter().flush();
			System.out.println("Funcionario gravado com sucesso");

		} catch (IOException erro) {
			// TODO Auto-generated catch block
			erro.printStackTrace();
		}
	}

	public List<Funcionario> listar() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferdReader();

			String linha = "";

			br.readLine();

			while (linha != null) {

				// extraíndo uma linha do arquivo
				linha = br.readLine();
				

				// Criando um vetor
				if (linha != null) {
					String funcionarioStr[] = linha.split(",");

					// Criando um objeto Funcionario
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcionarioStr[0]);
					funcionario.setNome(funcionarioStr[1]);
					funcionario.setCargo(funcionarioStr[2]);
					funcionario.setSalario(Double.parseDouble(funcionarioStr[3]));

					funcionarios.add(funcionario);
				}

			}

			return funcionarios;

		} catch (Exception erro) {
			erro.printStackTrace();
			return null;
		}
	}

}
