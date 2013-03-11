package com.mackstore.utils.misc;

public class HostEmail {
	private String nome, usuario, senha;
	private int porta;
	private boolean ssl = true, tls = true;

	public HostEmail(String nome, String usuario, String senha, int porta) {
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.porta = porta;
	}

	public HostEmail(String nome, int porta) {
		super();
		this.nome = nome;
		this.porta = porta;
	}

	public HostEmail(String nome, String usuario, String senha, int porta,
			boolean ssl, boolean tls) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.porta = porta;
		this.ssl = ssl;
		this.tls = tls;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

	public boolean isTls() {
		return tls;
	}

	public void setTls(boolean tls) {
		this.tls = tls;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
