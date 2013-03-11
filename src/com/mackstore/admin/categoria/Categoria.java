package com.mackstore.admin.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

@Entity(name="CategoriaBean")
@Table(name="tabCategoria")
public class Categoria extends ValidatorForm {
	private static final long serialVersionUID = -8266377267957121980L;
	private String nome;
	private long id;

	@Id
	@GeneratedValue
	@Column(name="intIdCategoria")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	@Column(name="strNome", nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        //ActionErrors errors = new ActionErrors();
		//SETA BEAN ATUAL
		request.setAttribute("atual", this);
		//return errors;
		return super.validate(mapping, request);
	}
}
