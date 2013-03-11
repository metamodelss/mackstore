package com.mackstore.admin.categoria.produto;

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

import com.mackstore.admin.cad_foto.Foto;
import com.mackstore.admin.cad_foto.FotoDAO;
import com.mackstore.admin.categoria.Categoria;
import com.mackstore.admin.categoria.CategoriaDAO;
import com.mackstore.utils.misc.CKEditor_Config;

@Entity(name="ProdutoBean")
@Table(name="tabProduto")
public class Produto extends ValidatorForm {
	private static final long serialVersionUID = -8266377267957121980L;
	private String nome,descricao;
	private long id,idCategoria,idFoto,quantidade;

	@Id
	@GeneratedValue
	@Column(name="intIdProduto")
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

	@Column(name="strDescricao", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name="intQuantidade", nullable = false)
	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name="intCategoria", nullable = false)
	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name="intFoto", nullable = false)
	public long getIdFoto() {
		return idFoto;
	}

	public void setIdFoto(long idFoto) {
		this.idFoto = idFoto;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        //ActionErrors errors = new ActionErrors();
		//GERA ARRAYLIST PARA COMBOBOX CATEGORIA
		ArrayList<Categoria> listaCategorias = CategoriaDAO.getInstance().listar();
		request.setAttribute("listaCategorias", listaCategorias);
		//GERA ARRAYLIST PARA COMBOBOX FOTO
		ArrayList<Foto> listaFotos = FotoDAO.getInstance().listar();
		request.setAttribute("listaFotos", listaFotos);
		//SETA BEAN ATUAL
		request.setAttribute("atual", this);
		//CONFIGURA CKEDITOR
		request.setAttribute("configCK", CKEditor_Config.configura());
		//return errors;
		return super.validate(mapping, request);
	}
}
