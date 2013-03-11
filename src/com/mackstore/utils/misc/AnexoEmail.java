package com.mackstore.utils.misc;

public class AnexoEmail {
	private String nome,caminho;

	public AnexoEmail(String nome, String caminho) {
		this.nome = nome;
		this.caminho = caminho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
