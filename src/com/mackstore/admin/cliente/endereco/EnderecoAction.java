package com.mackstore.admin.cliente.endereco;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EnderecoAction extends Action {
	private final String LISTAR = "listar";

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//CRUD
		//ADICIONA | LISTA | ALTERA | APAGA
	    ActionErrors erros = new ActionErrors();
		Endereco endereco = (Endereco) form;
		EnderecoDAO dao = new EnderecoDAO();
		//SALVA OU ALTERA
		if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")) {
			if (!dao.alterar(endereco)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"titulo"}));
		        saveErrors(request, erros);
			}
		}
		else {
			if (!dao.salvar(endereco)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"titulo"})); 
		        saveErrors(request, erros);
			}
		}
		ArrayList<Endereco> enderecos = dao.listar();
		if (enderecos != null && enderecos.size() > 0) {
			request.setAttribute("listar", enderecos); 
		}
		return mapping.findForward(LISTAR);
	}
}