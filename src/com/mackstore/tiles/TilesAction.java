package com.mackstore.tiles;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.mackstore.admin.cad_foto.Foto;
import com.mackstore.admin.cad_foto.FotoDAO;
import com.mackstore.admin.categoria.Categoria;
import com.mackstore.admin.categoria.CategoriaDAO;
import com.mackstore.admin.categoria.produto.Produto;
import com.mackstore.admin.categoria.produto.ProdutoDAO;

public class TilesAction extends DispatchAction{
	private static final String HOME = "home";
	private static final String CATEGORIA = "categoria";
//	private static int TOTAL_MENU = 9;
//	private static String[] menuAtual = new String[TOTAL_MENU];
	//DAOs
	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private static ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
	private static FotoDAO fotoDAO = FotoDAO.getInstance();

	public ActionForward home(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("entrou home");
//		return categoria(mapping, form, request, response);
		return mapping.findForward(HOME);
	}

	public ActionForward categoria(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		/*ITEM SELECIONADO*/
		ArrayList<Produto> produtos = null;
		if (id != null && !id.equals("")) {
			produtos = produtoDAO.listarPor("idCategoria="+id);
		}
		else {
			produtos = produtoDAO.listar();
		}
		//pega fotos
		if (produtos != null && produtos.size() > 0) {
			ArrayList<Foto> fotos = new ArrayList<Foto>();
			/*DADOS DE EXIBIO LISTA PACOTES E LISTA FOTOS*/
			if (produtos != null) {
				for (int i = 0; i < produtos.size(); i++) {
					//PEGA FOTO E ADICIONA NA LISTA PARALELA
					fotos.add(fotoDAO.get(produtos.get(i).getIdFoto()));
				}
				request.setAttribute("fotosProdutos", fotos);
			}
		}
		request.setAttribute("produtos", produtos);
		return mapping.findForward(CATEGORIA);
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		geraListaCategoria(request);
		return super.execute(mapping, form, request, response);
	}

	//GERA LISTA CATEGORIA
	private void geraListaCategoria(HttpServletRequest request){
		ArrayList<Categoria> listagem = categoriaDAO.listar();
		request.setAttribute("listagem", listagem);
	}
	//EFEITO CSS MENU ATUAL
//	private void criaMenuAtual(int indice, HttpServletRequest request){
//		Arrays.fill(menuAtual, null);
//		menuAtual[indice] =  "current";
//		request.setAttribute("menuAtual", menuAtual);
//	}
}