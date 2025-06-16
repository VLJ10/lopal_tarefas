package br.dev.vinicius.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		btnTarefas.setFont(new Font("Century", Font.PLAIN, 15));
		btnTarefas.setBounds(10, 80, 120, 30);
		
		btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setFont(new Font("Century", Font.PLAIN, 15));
		btnFuncionario.setBounds(150, 80, 120, 30);
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			   new FrameFuncionarioList(tela);
			   
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefasList(tela);
				
			}
		});
		
		painel.add(btnFuncionario);
		painel.add(labelTitulo);
		painel.add(btnTarefas);
		
		
		
		tela.setVisible(true);
		
	}
}
