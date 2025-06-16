package br.dev.vinicius.tarefas.ui;

import java.awt.Container;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.model.Funcionario;
import br.dev.vinicius.tarefas.model.Responsavel;
import br.dev.vinicius.tarefas.model.Status;

public class FrameTarefas {
	
	
	private JLabel labelTituloTarefas;
	private JTextField txtTituloTarefas;
	
	private JLabel labelDescricao;
	private JTextField txtDescricao;
	
	private JLabel labelInicio;
	private JTextField txtInicio;
	
	private JLabel labelPrazo;
	private JTextField txtPrazo;
	
	private JLabel labelDataConclusao;
	private JTextField txtDataConclusao;
	
	private JLabel labelStatus;
	private JLabel labelResponsavel;
	private JButton btnSalvar;
	private JButton btnSair;
	private JComboBox comboResponsavel;
	
	public FrameTarefas(JDialog frame) {
		criarTela(frame);
	}
	
	private void criarTela(JDialog frame) {
		JDialog tela = new JDialog(frame, true);
		tela.setTitle("Cadastro");
		tela.setSize(400, 600);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(frame);
		
		Container painel = tela.getContentPane();
		
		//Label Titulo
		labelTituloTarefas = new JLabel("Título");
		labelTituloTarefas.setBounds(10, 10, 200, 20);
		
		//txt Titulo 
		txtTituloTarefas = new JTextField();
		txtTituloTarefas.setBounds(10, 30, 300, 30);
		
		//Label Descrição
		labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(10, 70, 150, 20);
		
		//txt Descrição 
		txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 90, 300, 30);
		
		//label Inicio
		labelInicio = new JLabel("Início");
		labelInicio.setBounds(10, 130, 150, 20);
		
		//txt Inicio
		txtInicio = new JTextField();
		txtInicio.setBounds(10, 150, 150, 30);
		
		//Label Prazo 
		labelPrazo = new JLabel("Prazo");
		labelPrazo.setBounds(10, 190, 100, 20);
		
		//Txt Prazo
		txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 210, 100, 30);
		
		//label Data Conclusão
		labelDataConclusao = new JLabel("Data de Conclusão");
		labelDataConclusao.setBounds(10, 250, 200, 20);
		
		//txt Data Conclusão
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(10, 270, 100, 30);
		
		//status
		labelStatus = new JLabel("Status");
		labelStatus.setBounds(10, 310, 100, 20);
//		JComboBox comboResponsavel = new JComboBox;
		
		comboResponsavel.setBounds(10, 330, 130, 30);
		
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		String[][] responsaveis = new String[funcionarios.size()][1];
		int i = 0;
		for (Funcionario f : funcionarios) {
			responsaveis[0][0] = f.getNome();
			i++;
			
			comboResponsavel.addItem(responsaveis[0] [0]);
			
		}
		String responsavelSelecionado = (String) comboResponsavel.getSelectedItem();
		
		
		
		
		//Responsavel
		labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 370, 100, 20);
		Funcionario f = new Funcionario();
		JComboBox<String> fun = new JComboBox<>();
		fun.setBounds(10, 400, 200, 30);
		
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 500, 150, 30);
		
		btnSair =new JButton("Sair");
		btnSair.setBounds(170, 500, 150, 30);
		
		painel.add(labelTituloTarefas);
		painel.add(txtTituloTarefas);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelInicio);
		painel.add(txtInicio);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		painel.add(labelStatus);
		painel.add(comboResponsavel);
		painel.add(labelResponsavel);
		painel.add(fun);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		
		tela.setVisible(true);
	}
}
