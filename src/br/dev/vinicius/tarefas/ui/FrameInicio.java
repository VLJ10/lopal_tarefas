package br.dev.vinicius.tarefas.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameInicio {
	
	private JLabel labelTitulo;
	private JButton btnTarefas;
	private JButton btnFuncionario;
	
	public FrameInicio() {
		criarTela();
	}
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setSize(300, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Gerenciamento de Tarefas");
		tela.setResizable(false);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Gerenciamento de Tarefas");
		labelTitulo.setBounds(20, 20, 250, 30);
		labelTitulo.setFont(new Font("Century", Font.BOLD, 18));
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setFont(new Font("Century", Font.PLAIN, 18));
		btnTarefas.setBounds(20, 80, 100, 30);
		
		
		painel.add(labelTitulo);
		painel.add(btnTarefas);
		
		
		
		tela.setVisible(true);
		
	}
}
