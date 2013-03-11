package com.mackstore.admin.cad_dica;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.struts.validator.ValidatorForm;

@Entity(name="DicaBean")
@Table(name="tabDica")
public class Dica extends ValidatorForm {
	private static final long serialVersionUID = 2345678;
	private long id;
	private String nome,descricao;

	public Dica() {
	}
	public Dica(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	public Dica(long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue
	@Column(name="intIdDica")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="strNome",unique = true)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="strDescricao", columnDefinition="CLOB")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return id + " | " + nome + " | " + descricao;
	}
}
