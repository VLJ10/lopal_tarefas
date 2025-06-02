package br.dev.vinicius.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.model.Funcionario;

public class FrameFuncionarioList {
	
	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JTable tabelaFuncionario;
	private JScrollPane scrollFuncionario;
	private DefaultTableModel modelFuncionario;
	private String[] colunas = {"CÓDIGO", "NOME", "CARGO"};
	
	public FrameFuncionarioList () {
		criarTela();
	}
	
	private void criarTela() {
		
		JFrame tela = new JFrame();
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Lista de Funcionario");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionario");
		labelTitulo.setFont(new Font("Century", Font.BOLD, 30));
		labelTitulo.setForeground(Color.ORANGE);
		labelTitulo.setBounds(10, 10, 400, 40);
		
		
		//Criando a tabela
		modelFuncionario = new DefaultTableModel(colunas, 10) {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		
		tabelaFuncionario = new JTable(modelFuncionario);
		tabelaFuncionario.getTableHeader().setReorderingAllowed(false);
		scrollFuncionario = new JScrollPane(tabelaFuncionario);
		scrollFuncionario.setBounds(10, 60, 560, 400);
		
		carregarDados();
		
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 470, 100, 30);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
				carregarDados();
			}
		});
		
		painel.add(labelTitulo);
		painel.add(scrollFuncionario);
		painel.add(btnCadastro);
		
		tela.setVisible(true);
	}
	
	private void carregarDados() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int i = 0;
		
		for (Funcionario f : funcionarios) {
			dados[i][0] = f.getMatricula();
			dados[i][1] = f.getNome();
			dados[i][2] = f.getCargo();
			i++;
		}
		
		modelFuncionario.setDataVector(dados, colunas);
	}
	
}
