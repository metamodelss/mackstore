package com.mackstore.admin.cliente.endereco;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class EnderecoDAO extends GenericDAO<Endereco> {
	private static EnderecoDAO dao = null;

	public EnderecoDAO() {
		super(Endereco.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Endereco> listar(String filtro,int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Endereco> enderecos = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Endereco.class.getName();
			if (filtro != null && filtro.equals("")) {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(rua) like lower('%"+filtro+"%')";
				}
			}
			enderecos = (ArrayList<Endereco>)sessao.createQuery(hql_query).list();
			if (limite > 0 && limite < enderecos.size()) {
				enderecos = (ArrayList<Endereco>) enderecos.subList(0, limite);
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
	public ArrayList<Endereco> listar(String filtro) {
		return listar(filtro, 0);
	}

	public static EnderecoDAO getInstance() {  
	      if (dao == null) {  
	          dao = new EnderecoDAO();  
	      }  
	      return dao;  
	} 
}
