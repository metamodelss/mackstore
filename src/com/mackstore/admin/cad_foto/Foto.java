package com.mackstore.admin.cad_foto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

@Entity(name = "FotoBean")
@Table(name = "tabFoto")
public class Foto extends ActionForm {
	private static final long serialVersionUID = 2345678;
	private long id;
	private String nome;
	private FormFile file;
	private String arquivo;

	public Foto() {
	}

	public Foto(String nome, FormFile file) {
		this.nome = nome;
		this.file = file;
	}

	public Foto(long id, String nome, FormFile file) {
		this.id = id;
		this.nome = nome;
		this.file = file;
	}

	@Id
	@GeneratedValue
	@Column(name = "intIdFoto")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "strNome", nullable = false, unique = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "strArquivo", nullable = false)
	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	@Transient
	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
		arquivo = file.getFileName();
	}

	@Override
	public String toString() {
		return id + " | " + nome + " | " + arquivo;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
		StringBuilder tiposArq = new StringBuilder();
		tiposArq.append("image/jpeg,");
		tiposArq.append("image/gif,");
		tiposArq.append("image/png,");
		tiposArq.append("image/bmp");
		tiposArq.append("image/x-png");
		tiposArq.append("image/pjpeg");
		tiposArq.append("image/x-png");
//		System.out.println("TIPO DO ARQUIVO: "+getFile().getContentType());

        if (nome.length() <= 0) {
            errors.add("nome", new ActionMessage("errors.nome.required"));
        }
        //SE CAMPO ARQUIVO EXISTE E FILE NULO(ALTERAR)
        if (arquivo.length() > 0 && getFile().getFileSize() == 0) {
			return errors;
		}
		if (getFile().getFileSize() == 0) {
			errors.add("file", new ActionMessage("errors.arquivo.required"));
		}
		// só imagens
		else if (tiposArq.toString().indexOf(getFile().getContentType()) == -1) {
			errors.add("file", new ActionMessage(
					"errors.arquivo.tipoArquivo"));
		}
		// max 200 kb
		else if (getFile().getFileSize() > (200 * 1024)) { // 200kb
			errors.add("file", new ActionMessage(
					"errors.arquivo.fileMaxSize200"));
		}
		this.reset(mapping, request);		
        return errors;
    }
}