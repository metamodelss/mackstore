package com.mackstore.admin.categoria.produto;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class ProdutoDAO extends GenericDAO<Produto> {
	private static ProdutoDAO dao = null;

	public ProdutoDAO() {
		super(Produto.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produto> listar(String filtro,int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Produto> produtos = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Produto.class.getName();
			if (filtro != null && filtro.equals("")) {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(nome) like lower('%"+filtro+"%')";
				}
			}
			produtos = (ArrayList<Produto>)sessao.createQuery(hql_query).list();
			if (limite > 0 && limite < produtos.size()) {
				produtos = (ArrayList<Produto>) produtos.subList(0, limite);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return produtos;
	}

	@Override
	public ArrayList<Produto> listar(String filtro) {
		return listar(filtro, 0);
	}

	public static ProdutoDAO getInstance() {  
	      if (dao == null) {  
	          dao = new ProdutoDAO();  
	      }  
	      return dao;  
	} 
}
