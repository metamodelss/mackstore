package com.mackstore.admin.categoria;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class CategoriaDAO extends GenericDAO<Categoria> {
	private static CategoriaDAO dao = null;

	public CategoriaDAO() {
		super(Categoria.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Categoria> listar(String filtro,int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Categoria> categoria = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Categoria.class.getName();
			if (filtro != null && filtro.equals("")) {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(nome) like lower('%"+filtro+"%')";
				}
			}
			categoria = (ArrayList<Categoria>)sessao.createQuery(hql_query).list();
			if (limite > 0 && limite < categoria.size()) {
				categoria = (ArrayList<Categoria>) categoria.subList(0, limite);
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
		return categoria;
	}

	@Override
	public ArrayList<Categoria> listar(String filtro) {
		return listar(filtro, 0);
	}

	public static CategoriaDAO getInstance() {  
	      if (dao == null) {  
	          dao = new CategoriaDAO();  
	      }  
	      return dao;  
	} 
}
