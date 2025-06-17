package br.dev.vinicius.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.dao.TarefasDAO;
import br.dev.vinicius.tarefas.model.Funcionario;
import br.dev.vinicius.tarefas.model.Tarefas;

public class FrameFuncionario {
	
	private JLabel labelMatricula;
	private JLabel labelNome;
	private JLabel labelCargo;
	private JLabel labelSalario;
	private JTextField txtMatricula;
	private JTextField txtNome;
	private JTextField txtCargo;
	private JTextField txtSalario;
	private JButton btnSalvar;
	private JButton btnSair;
	
	public FrameFuncionario(JDialog frame) {
		criarTela(frame);
	}
	
	private void criarTela(JDialog frame) {
		JDialog tela = new JDialog(frame, true);
		tela.setTitle("Cadastro");
		tela.setSize(400, 400);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(frame);
		
		Container painel = tela.getContentPane();
		
		//Label Matricula
		labelMatricula = new JLabel("Matricula:");
		labelMatricula.setBounds(10, 10, 200, 30);
		
		//Text Fild Matricula
		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 40, 150, 30);
		txtMatricula.setEnabled(false);
		
		//Label Nome
		labelNome = new JLabel("Nome:");
		labelNome.setBounds(10, 75, 200, 30);
		
		//txt Nome
		txtNome = new JTextField();
		txtNome.setBounds(10, 105, 365, 30);
		
		//label Cargo
		labelCargo = new JLabel("Cargo:");
		labelCargo.setBounds(10, 140, 200, 30);
		
		//txt cargo
		txtCargo = new JTextField();
		txtCargo.setBounds(10, 175, 300, 30);
		
		//label Salario
		labelSalario = new JLabel("Salario:");
		labelSalario.setBounds(10, 210, 200, 30);
		
		//txt Salario
		txtSalario = new JTextField();
		txtSalario.setBounds(10, 245, 150, 30);
		
		//Botão salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 300, 120, 50);
		
		//botão sair
		btnSair = new JButton("Sair");
		btnSair.setBounds(150, 300, 120, 50);
		
		
		painel.add(labelMatricula);
		painel.add(txtMatricula);
		painel.add(labelNome);
		painel.add(txtNome);
		painel.add(labelCargo);
		painel.add(txtCargo);
		painel.add(labelSalario);
		painel.add(txtSalario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				JOptionPane.showMessageDialog(tela, "Deseja fechar a tela", "Fechar", JOptionPane.ERROR_MESSAGE);
				int resposta = JOptionPane.showConfirmDialog(painel, "Deseja fecha o app");
		        System.out.println(resposta);
				if (resposta == 0) {
					tela.dispose();
					
				} else {

				}
				
				
				
			}
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Funcionario f = 
					new Funcionario(
						txtCargo.getText(), 
						txtNome.getText(), 
						Double.parseDouble(txtSalario.getText())
					);
				FuncionarioDAO dao = new FuncionarioDAO(f);
				dao.gravar();
				JOptionPane.showMessageDialog(tela, 
						txtNome.getText() + "\nGravado com sucesso",
						"Sucesso" , JOptionPane.INFORMATION_MESSAGE);
				limparFomulario();
			}
		});
		
		
		tela.setVisible(true);
	}
	
	private void limparFomulario() {
		txtNome.setText(null);
		txtCargo.setText(null);
		txtSalario.setText(null);
		txtNome.requestFocus();
	}
	
}
