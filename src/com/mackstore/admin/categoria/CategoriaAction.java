package com.mackstore.admin.categoria;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CategoriaAction extends Action {
	private final String LISTAR = "listar";

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//CRUD
		//ADICIONA | LISTA | ALTERA | APAGA
	    ActionErrors erros = new ActionErrors();
		Categoria categoria = (Categoria) form;
		CategoriaDAO dao = new CategoriaDAO();
		//SALVA OU ALTERA
		if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")) {
			if (!dao.alterar(categoria)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"titulo"}));
		        saveErrors(request, erros);
			}
		}
		else {
			if (!dao.salvar(categoria)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"titulo"})); 
		        saveErrors(request, erros);
			}
		}
		ArrayList<Categoria> categorias = dao.listar();
		if (categorias != null && categorias.size() > 0) {
			request.setAttribute("listar", categorias); 
		}
		return mapping.findForward(LISTAR);
	}
}