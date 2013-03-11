package com.mackstore.admin.cad_admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginAction extends Action {
	private final String LOGIN = "login";
	private final String ERRO = "erro";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Admin admin = (Admin) form;
		AdminDAO dao = new AdminDAO();
		admin = dao.login(admin);
                System.out.println("admin: "+admin);
		if (admin == null) {
			ActionErrors erros = new ActionErrors();
			erros.add("loginIncorreto", new ActionMessage("errors.login"));
			saveErrors(request.getSession(), erros);
			return mapping.findForward(ERRO);
		} else {
			HttpSession sessao = request.getSession();
			sessao.setMaxInactiveInterval(5*60);
			sessao.setAttribute("id_login", admin.getId());
			sessao.setAttribute("usuario_login", admin.getUsuario());
			return mapping.findForward(LOGIN);
		}
	}
}
