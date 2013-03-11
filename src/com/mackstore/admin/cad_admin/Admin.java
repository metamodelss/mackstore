package com.mackstore.admin.cad_admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.struts.validator.ValidatorForm;

@Entity(name="AdminBean")
@Table(name="tabAdmin")
public class Admin extends ValidatorForm {
	private static final long serialVersionUID = 2345678;
	private String usuario,senha,email;
	private long id;

	public Admin() {
	}
	public Admin(String usuario, String senha, String email) {
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}
	public Admin(long id, String usuario, String senha, String email) {
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.email = email;
	}

	@Id
	@GeneratedValue
	@Column(name="intIdAdmin")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="strUsuario", nullable = false, unique = true)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name="strSenha", nullable = false)
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name="strEmail", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + " | " + usuario + " | " + senha + " | " + email;
	}
}