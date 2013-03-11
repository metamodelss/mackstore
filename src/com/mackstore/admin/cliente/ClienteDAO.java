package com.mackstore.admin.cliente;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente> {
	private static ClienteDAO dao = null;

	public ClienteDAO() {
		super(Cliente.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> listar(String filtro,int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Cliente> enderecos = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Cliente.class.getName();
			if (filtro != null && filtro.equals("")) {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(nome) like lower('%"+filtro+"%')";
				}
			}
			enderecos = (ArrayList<Cliente>)sessao.createQuery(hql_query).list();
			if (limite > 0 && limite < enderecos.size()) {
				enderecos = (ArrayList<Cliente>) enderecos.subList(0, limite);
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
		return enderecos;
	}

	@Override
	public ArrayList<Cliente> listar(String filtro) {
		return listar(filtro, 0);
	}

	public static ClienteDAO getInstance() {  
	      if (dao == null) {  
	          dao = new ClienteDAO();  
	      }  
	      return dao;  
	} 
}
