package br.dev.vinicius.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.dao.TarefasDAO;
import br.dev.vinicius.tarefas.model.Funcionario;

import br.dev.vinicius.tarefas.model.Status;
import br.dev.vinicius.tarefas.model.Tarefas;

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
		txtDataConclusao.setEnabled(false);
		
		//status
		labelStatus = new JLabel("Status");
		labelStatus.setBounds(10, 310, 100, 20);
		JComboBox<Status> cmx = new JComboBox<>(Status.values());
		cmx.setBounds(10, 330, 130, 30);
		
		
		//Responsavel
		labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 370, 100, 20);
		
		
		comboResponsavel = new JComboBox<>(); 
		comboResponsavel.setBounds(10, 390, 130, 30);
		
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
		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 500, 150, 30);
		
		btnSair =new JButton("Sair");
		btnSair.setBounds(170, 500, 150, 30);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				Funcionario f = new Funcionario();
				Tarefas t = 
					new Tarefas(
							txtTituloTarefas.getText(),
							txtDescricao.getText(),
							LocalDate.parse(txtInicio.getText(), formatter),
							Integer.parseInt(txtPrazo.getText()),
							responsavelSelecionado
						);
				t.setResponsavel(f.getNome());
				t.getResponsavel();
				TarefasDAO dao = new TarefasDAO(t);
				dao.gravar();
				JOptionPane.showMessageDialog(tela, 
						txtTituloTarefas.getText() + "\nGravado com Sucesso", 
						"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				limparFomulario();
				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(painel, "Deseja fechar o app");
				if (resposta == 0) {
					tela.dispose();
				} else {

				}
			}
		});
		
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
		painel.add(cmx);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		
		
		tela.setVisible(true);
	}
	private void limparFomulario() {
		txtTituloTarefas.setText(null);
		txtDescricao.setText(null);
		txtInicio.setText(null);
		txtPrazo.setText(null);
		txtTituloTarefas.requestFocus();
	}
}
