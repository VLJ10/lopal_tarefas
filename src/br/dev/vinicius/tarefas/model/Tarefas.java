package br.dev.vinicius.tarefas.model;

import java.time.LocalDate;

import br.dev.vinicius.tarefas.dao.FuncionarioDAO;
import br.dev.vinicius.tarefas.utils.Utils;

public class Tarefas {
	private String titulo;
	private String descricao;
	private LocalDate inicio;
	private int prazo;
	private String codigo;
	private String responsavel;
	
	
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public Tarefas() {
		this.setCodigo(Utils.gerarUUID8());
	}
	public Tarefas(String titulo) {
		this.setCodigo(Utils.gerarUUID8());
		this.titulo = titulo;
	}
	public Tarefas(String titulo, String descricao) {
		this.setCodigo(Utils.gerarUUID8());
		this.titulo = titulo;
		this.descricao = descricao;
	}
	public Tarefas(String titulo, String descricao, LocalDate inicio) {
		this.setCodigo(Utils.gerarUUID8());
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
	}
	public Tarefas(String titulo, String descricao, LocalDate inicio, int prazo) {
		this.setCodigo(Utils.gerarUUID8());
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.prazo = prazo;
	}
	public Tarefas(String titulo, String descricao, LocalDate inicio, int prazo, String responsavel) {
		this.setCodigo(Utils.gerarUUID8());
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.prazo = prazo;
		this.responsavel = responsavel;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescrição(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getInicio() {
		return inicio;
	}
	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
	
	private LocalDate conclusao() {
		LocalDate conclusao = inicio.plusDays(prazo);
		return conclusao;
		}
	
	
	@Override
	public String toString() {
		String tarefa = titulo + "," + descricao + "," + inicio +
				"," + prazo + "," + conclusao() + "\n";
		return tarefa;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
