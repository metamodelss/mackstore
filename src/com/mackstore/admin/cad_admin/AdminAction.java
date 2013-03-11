package com.mackstore.admin.cad_admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AdminAction extends Action {
	private final String LISTAR = "listar";

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//CRUD
		//ADICIONA | LISTA | ALTERA | APAGA
	    ActionErrors erros = new ActionErrors();
		Admin admin = (Admin) form;
		AdminDAO dao = new AdminDAO();
		if (request.getParameter("id") != null && request.getParameter("id") != "") {
			if (!dao.alterar(admin)) {
				erros.add( "usuarioRepetido", new ActionMessage("errors.unique",new Object[]{"usuário"})); 
		        saveErrors(request, erros);
			}
		}
		else {
			if (!dao.salvar(admin)) {
				erros.add( "usuarioRepetido", new ActionMessage("errors.unique",new Object[]{"usuário"}));  
		        saveErrors(request, erros);
			}
		}
		ArrayList<Admin> admins = dao.listar();
		if (admins.size() > 0) {
			request.setAttribute("listarAdmin", admins);
		}
		return mapping.findForward(LISTAR);
	}
}
