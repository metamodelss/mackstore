package com.mackstore.admin.cliente;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ClienteAction extends Action {
	private final String LISTAR = "listar";

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//CRUD
		//ADICIONA | LISTA | ALTERA | APAGA
	    ActionErrors erros = new ActionErrors();
		Cliente cliente = (Cliente) form;
		ClienteDAO dao = new ClienteDAO();
		//SALVA OU ALTERA
		if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")) {
			if (!dao.alterar(cliente)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"nome"}));
		        saveErrors(request, erros);
			}
		}
		else {
			if (!dao.salvar(cliente)) {
				erros.add( "dadoRepetido", new ActionMessage("errors.unique",new Object[]{"nome"})); 
		        saveErrors(request, erros);
			}
		}
		ArrayList<Cliente> clientes = dao.listar();
		if (clientes != null && clientes.size() > 0) {
			request.setAttribute("listar", clientes); 
		}
		return mapping.findForward(LISTAR);
	}
}