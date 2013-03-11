package com.mackstore.admin.cliente;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import com.mackstore.admin.cliente.endereco.Endereco;
import com.mackstore.admin.cliente.endereco.EnderecoDAO;

@Entity(name="ClienteBean")
@Table(name="tabCliente")
public class Cliente extends ValidatorForm {
	private static final long serialVersionUID = -8266377267957121980L;
	private String nome;
	private long id,idEndereco;

	@Id
	@GeneratedValue
	@Column(name="intIdCliente")
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

	@Column(name="idEndereco", nullable = false)
	public long getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(long idEndereco) {
		this.idEndereco = idEndereco;
	}	

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        //ActionErrors errors = new ActionErrors();
		//GERA ARRAYLIST PARA COMBOBOX NOTICIA E CHAMA SUPERCLASSE VALIDA
		ArrayList<Endereco> listaEnderecos = EnderecoDAO.getInstance().listar();
		request.setAttribute("listaEnderecos", listaEnderecos);
		//SETA BEAN ATUAL
		request.setAttribute("atual", this);
		//return errors;
		return super.validate(mapping, request);
	}

}
