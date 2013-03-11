package com.mackstore.admin.cad_dica;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class DicaDAO extends GenericDAO<Dica> {
	private static DicaDAO dao = null;

	public DicaDAO() {
		super(Dica.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Dica> listar(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Dica> dicas = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Dica.class.getName();
			if (filtro != null && filtro != "") {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(nome) like lower('%"+filtro+"%')";
				}
			}

			dicas = (ArrayList<Dica>)sessao.createQuery(hql_query).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return dicas;
	}

	public static DicaDAO getInstance() {  
	      if (dao == null) {  
	          dao = new DicaDAO();  
	      }  
	      return dao;  
	} 

}
