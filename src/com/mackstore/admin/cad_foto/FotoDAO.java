package com.mackstore.admin.cad_foto;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class FotoDAO extends GenericDAO<Foto> {
	private static FotoDAO dao = null;

	public FotoDAO() {
		super(Foto.class);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Foto> listar(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Foto> fotos = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Foto.class.getName();
			if (filtro != null && filtro != "") {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(nome) like lower('%"+filtro+"%')";
				}
			}

			fotos = (ArrayList<Foto>)sessao.createQuery(hql_query).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return fotos;
	}

	public static FotoDAO getInstance() {  
	      if (dao == null) {  
	          dao = new FotoDAO();  
	      }  
	      return dao;  
	} 
}
