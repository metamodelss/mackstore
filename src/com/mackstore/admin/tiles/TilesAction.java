package com.mackstore.admin.tiles;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.mackstore.admin.cad_admin.Admin;
import com.mackstore.admin.cad_admin.AdminDAO;
import com.mackstore.admin.cad_dica.Dica;
import com.mackstore.admin.cad_dica.DicaDAO;
import com.mackstore.admin.cad_foto.Foto;
import com.mackstore.admin.cad_foto.FotoDAO;
import com.mackstore.admin.categoria.Categoria;
import com.mackstore.admin.categoria.CategoriaDAO;
import com.mackstore.admin.categoria.produto.Produto;
import com.mackstore.admin.categoria.produto.ProdutoDAO;
import com.mackstore.admin.cliente.Cliente;
import com.mackstore.admin.cliente.ClienteDAO;
import com.mackstore.admin.cliente.endereco.Endereco;
import com.mackstore.admin.cliente.endereco.EnderecoDAO;
import com.mackstore.utils.misc.CKEditor_Config;
import com.mackstore.utils.misc.Upload;

public class TilesAction extends DispatchAction{
	private final String HOME = "home";
	private final String ADMIN = "admin";
	private final String CAD_ADMIN = "cadAdmin";
	private final String FOTO = "foto";
	private final String CAD_FOTO = "cadFoto";
	private final String DICA = "dica";
	private final String CAD_DICA = "cadDica";
	private final String LOGOUT = "logout";
	private static AdminDAO adminDAO = AdminDAO.getInstance();
	private static FotoDAO fotoDAO = FotoDAO.getInstance();
	private static DicaDAO dicaDAO = DicaDAO.getInstance();
	private static Random randomGenerator;
	//MACKSTORE
	private static EnderecoDAO enderecoDAO = EnderecoDAO.getInstance();
	private static ClienteDAO clienteDAO = ClienteDAO.getInstance();
	private static CategoriaDAO categoriaDAO = CategoriaDAO.getInstance();
	private static ProdutoDAO produtoDAO = ProdutoDAO.getInstance();
	private final String ENDERECO = "endereco";
	private final String CAD_ENDERECO = "cadEndereco";
	private final String CLIENTE = "cliente";
	private final String CAD_CLIENTE = "cadCliente";
	private final String CATEGORIA = "categoria";
	private final String CAD_CATEGORIA = "cadCategoria";
	private final String PRODUTO = "produto";
	private final String CAD_PRODUTO = "cadProduto";

	public ActionForward home(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String modo = request.getParameter("modo");
		if (modo != null && modo.equals("logout")) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("id_login", null);
			sessao.setAttribute("usuario_login", null);
			return mapping.findForward(LOGOUT);
		}
		return mapping.findForward(HOME);
	}

	public ActionForward admin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && !request.getParameter("deletaId").equals("")) {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			adminDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Admin> admins = adminDAO.listar(filtro);
		if (admins.size() > 0) {
			request.setAttribute("listarAdmin", admins); 
		}
		return mapping.findForward(ADMIN);
	}

	public ActionForward cadAdmin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			Admin admin = adminDAO.get(id);
			request.setAttribute("adminAtual", admin); 
		}
		return mapping.findForward(CAD_ADMIN);
	}

	public ActionForward foto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			//DELETA O ARQUIVO
			String caminho = getServlet().getServletContext().getRealPath("/admin/arquivos");
			if (Upload.deletaArquivo(caminho, deletaId)) {
				fotoDAO.apagar(deletaId);
			}
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Foto> fotos = fotoDAO.listar(filtro);
		if (fotos.size() > 0) {
			request.setAttribute("listar", fotos); 
		}
		return mapping.findForward(FOTO);
	}

	public ActionForward cadFoto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Foto foto = null;
		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			foto = fotoDAO.get(id);
			request.setAttribute("atual", foto);
		}
		return mapping.findForward(CAD_FOTO);
	}

	public ActionForward produto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			produtoDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Produto> produtos = produtoDAO.listar(filtro);
		if (produtos != null && produtos.size() > 0) {
			request.setAttribute("listar", produtos); 
		}
		return mapping.findForward(PRODUTO);
	}

	public ActionForward cadProduto(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Produto produto = null;


		//GERA ARRAYLIST PARA COMBOBOX CATEGORIA
		ArrayList<Categoria> listaCategorias = categoriaDAO.listar();
		System.out.println(listaCategorias);
		request.setAttribute("listaCategorias", listaCategorias);
		//GERA ARRAYLIST PARA COMBOBOX FOTOS
		ArrayList<Foto> listaFotos = fotoDAO.listar();
		request.setAttribute("listaFotos", listaFotos);

		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			produto = produtoDAO.get(id);
			request.setAttribute("atual", produto);
		}
		//CONFIGURA CKEDITOR
		request.setAttribute("configCK", CKEditor_Config.configura());
		return mapping.findForward(CAD_PRODUTO);
	}

	public ActionForward cliente(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			clienteDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Cliente> clientes = clienteDAO.listar(filtro);
		if (clientes != null && clientes.size() > 0) {
			request.setAttribute("listar", clientes); 
		}
		return mapping.findForward(CLIENTE);
	}

	public ActionForward cadCliente(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Cliente cliente = null;

		//GERA ARRAYLIST PARA COMBOBOX FOTOS
		ArrayList<Endereco> listaEnderecos = enderecoDAO.listar();
		request.setAttribute("listaEnderecos", listaEnderecos);

		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			cliente = clienteDAO.get(id);
			request.setAttribute("atual", cliente);
		}
		return mapping.findForward(CAD_CLIENTE);
	}
	
	public ActionForward categoria(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			categoriaDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Categoria> categorias = categoriaDAO.listar(filtro);
		if (categorias.size() > 0) {
			request.setAttribute("listar", categorias); 
		}
		return mapping.findForward(CATEGORIA);
	}

	public ActionForward cadCategoria(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Categoria categoria = null;

		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			categoria = categoriaDAO.get(id);
			request.setAttribute("atual", categoria);
		}
		//CONFIGURA CKEDITOR
		request.setAttribute("configCK", CKEditor_Config.configura());
		return mapping.findForward(CAD_CATEGORIA);
	}
	
	public ActionForward endereco(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			enderecoDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Endereco> enderecos = enderecoDAO.listar(filtro);
		if (enderecos.size() > 0) {
			request.setAttribute("listar", enderecos); 
		}
		return mapping.findForward(ENDERECO);
	}

	public ActionForward cadEndereco(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Endereco endereco = null;

		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			endereco = enderecoDAO.get(id);
			request.setAttribute("atual", endereco);
		}
		//CONFIGURA CKEDITOR
		request.setAttribute("configCK", CKEditor_Config.configura());
		return mapping.findForward(CAD_ENDERECO);
	}
	
	public ActionForward dica(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (request.getParameter("deletaId") != null && request.getParameter("deletaId") != "") {
			long deletaId = Integer.parseInt(request.getParameter("deletaId"));
			dicaDAO.apagar(deletaId);
		}
		String filtro = request.getParameter("filtro");
		if (filtro != null) {
			filtro = request.getParameter("filtro");
		}
		ArrayList<Dica> dicas = dicaDAO.listar(filtro);
		if (dicas.size() > 0) {
			request.setAttribute("listar", dicas); 
		}
		return mapping.findForward(DICA);
	}

	public ActionForward cadDica(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Dica dica = null;

		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			dica = dicaDAO.get(id);
			request.setAttribute("atual", dica);
		}
		//CONFIGURA CKEDITOR
		request.setAttribute("configCK", CKEditor_Config.configura());
		return mapping.findForward(CAD_DICA);
	}
	
	private Dica sorteiaDica(){
		ArrayList<Dica> sorteiaDicas = dicaDAO.listar();
		if (!(sorteiaDicas.size() > 0)) {
			return null;
		}
	    if (randomGenerator == null) {  
	    	randomGenerator = new Random();
	    }
		int index = randomGenerator.nextInt(sorteiaDicas.size());
		return sorteiaDicas.get(index); 
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("dica", sorteiaDica());
		return super.execute(mapping, form, request, response);
	}
}