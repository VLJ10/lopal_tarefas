package br.dev.vinicius.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.dao.TarefasDAO;
import br.dev.vinicius.tarefas.model.Funcionario;
import br.dev.vinicius.tarefas.model.Tarefas;

public class FrameTarefasList {

	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;
	private String[] colunas = {"CODIGO", "RESPONSAVEL", "INICIO", "PRAZO"};
	
	public FrameTarefasList (JFrame frameList) {
		criarTela(frameList);
	}
	
	private void criarTela(JFrame frameList) {
		
		JDialog tela = new JDialog();
		tela.setSize(800, 600);
		tela.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(frameList);
		tela.setTitle("Lista de Tarefas");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setFont(new Font("Century", Font.BOLD, 30));
		labelTitulo.setForeground(Color.ORANGE);
		labelTitulo.setBounds(10, 10, 400, 40);
		
		
		//Criando a tabela
		modelTarefas = new DefaultTableModel(colunas, 10) {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		};
		
		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 60, 760, 400);
		
		carregarDados();
		
		btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBounds(10, 470, 100, 30);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefas(tela);
				carregarDados();
			}
		});
		
		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnCadastro);
		
		tela.setVisible(true);
	}
	
	private void carregarDados() {
		TarefasDAO dao = new TarefasDAO();
		List<Tarefas> tarefas = dao.listar();
		
		
		Object[][] dados = new Object[tarefas.size()][4];
		
		int i = 0;
		
		for (Tarefas t : tarefas) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getResponsavel();
			dados[i][2] = t.getInicio();
			dados[i][3] = t.getPrazo();
			i++;
		}
		
		modelTarefas.setDataVector(dados, colunas);
	}
	
}

