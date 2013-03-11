package com.mackstore.admin.cad_admin;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mackstore.admin.hibernate.GenericDAO;
import com.mackstore.admin.hibernate.HibernateUtil;

public class AdminDAO extends GenericDAO<Admin> {
	private static AdminDAO dao = null;

	public AdminDAO() {
		super(Admin.class);
	}
	
	@SuppressWarnings("unchecked")
	public Admin login(Admin admin){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Admin> admins = null;
		try {
			transaction = sessao.beginTransaction();
			admins = (ArrayList<Admin>)sessao.createQuery(
					"from "+Admin.class.getName()+" where " +
					"usuario='"+admin.getUsuario()+"' and senha='"+admin.getSenha()+"'")
					.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		if (admins.size() <= 0) {
			return null;
		}
		else {
			return admins.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Admin> listar(String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Admin> admins = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from "+Admin.class.getName();
			if (filtro != null && filtro != "") {
				try {
					long numFiltro = Long.parseLong(filtro);
					hql_query+=" where str(id) like '%"+numFiltro+"%'";
				} catch (Exception e) {
					hql_query+=" where lower(usuario) like lower('%"+filtro+"%')";
				}
			}

			admins = (ArrayList<Admin>)sessao.createQuery(hql_query).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return admins;
	}

	public static AdminDAO getInstance() {  
	      if (dao == null) {  
	          dao = new AdminDAO();  
	      }  
	      return dao;  
	} 
}
