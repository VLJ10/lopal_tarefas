package br.dev.vinicius.tarefas.model;

import java.time.LocalDate;

import br.dev.vinicius.tarefas.utils.Utils;

public class Tarefas {
	private String titulo;
	private String descricao;
	private LocalDate inicio;
	private int prazo;
	private String codigo;
	
	
	public Tarefas() {
		this.codigo = Utils.gerarUUID8();
	}
	public Tarefas(String titulo) {
		this.codigo = Utils.gerarUUID8();
		this.titulo = titulo;
	}
	public Tarefas(String titulo, String descricao) {
		this.codigo = Utils.gerarUUID8();
		this.titulo = titulo;
		this.descricao = descricao;
	}
	public Tarefas(String titulo, String descricao, LocalDate inicio) {
		this.codigo = Utils.gerarUUID8();
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
	}
	public Tarefas(String titulo, String descricao, LocalDate inicio, int prazo) {
		this.codigo = Utils.gerarUUID8();
		this.titulo = titulo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.prazo = prazo;
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
}
