package com.mackstore.tiles;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class TilesAction extends DispatchAction{
	private static final String CONTATO = "contato";
	private static final String TRABALHE = "trabalhe";
	private static int TOTAL_MENU = 9;
	private static String[] menuAtual = new String[TOTAL_MENU];
	public ActionForward contato(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//EFEITO CSS MENU ATUAL
		criaMenuAtual(8, request);
		return mapping.findForward(CONTATO);
	}
	
	public ActionForward trabalhe(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//EFEITO CSS MENU ATUAL
		criaMenuAtual(8, request);
		return mapping.findForward(TRABALHE);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.execute(mapping, form, request, response);
	}

	//EFEITO CSS MENU ATUAL
	private void criaMenuAtual(int indice, HttpServletRequest request){
		Arrays.fill(menuAtual, null);
		menuAtual[indice] =  "current";
		request.setAttribute("menuAtual", menuAtual);
	}
}