package com.mackstore.admin.cad_foto;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.mackstore.utils.misc.Upload;

public class FotoAction extends Action {
	private final String LISTAR = "listar";

	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//CRUD
		//ADICIONA | LISTA | ALTERA | APAGA
	    ActionErrors erros = new ActionErrors();
		Foto foto = (Foto) form;
		FotoDAO dao = new FotoDAO();
		//UPLOAD DE ARQUIVO
		String caminho = getServlet().getServletContext().getRealPath("/admin/arquivos");
		if (foto.getFile().getFileSize() > 0) {
			Upload.enviaArquivo(caminho, foto);	
		}
		//SALVA OU ALTERA
		if (request.getParameter("id") != null && !request.getParameter("id").equals("") && !request.getParameter("id").equals("0")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Upload.deletaArquivo(caminho, id);
			if (!dao.alterar(foto)) {
				erros.add( "usuarioRepetido", new ActionMessage("errors.unique",new Object[]{"nome"}));
		        saveErrors(request, erros);
			}
		}
		else {
			if (!dao.salvar(foto)) {
				erros.add( "usuarioRepetido", new ActionMessage("errors.unique",new Object[]{"nome"})); 
		        saveErrors(request, erros);
			}
		}
		ArrayList<Foto> fotos = dao.listar();
		if (fotos.size() > 0) {
			request.setAttribute("listar", fotos); 
		}
		return mapping.findForward(LISTAR);
	}
}