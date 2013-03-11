package com.mackstore.admin.cliente.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

@Entity(name="EnderecoBean")
@Table(name="tabEndereco")
public class Endereco extends ValidatorForm {
	private static final long serialVersionUID = -8266377267957121980L;
	private String rua,numero,complemento;
	private long id;

	@Id
	@GeneratedValue
	@Column(name="intIdEndereco")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	@Column(name="strRua", nullable = false, unique = true)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(name="strNumero", nullable = false, unique = true)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name="strComplemento", nullable = false, unique = true)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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
