package com.mackstore.admin.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

@SuppressWarnings("unchecked")
public abstract class GenericDAO<Bean> {
	/* CONSTANTES DE ORDENAÇÃO */
	static public final int ORDENA_CRESCENTE = 0;
	static public final int ORDENA_DECRESCENTE = 1;
	/* ATRIBUTOS */
	private Class<Bean> classe;

	public GenericDAO(Class<Bean> classe) {
		this.classe = classe;
	}

	public boolean salvar(Bean bean) {
		boolean objSalvo = false;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = sessao.beginTransaction();
			sessao.save(bean);
			transaction.commit();
			objSalvo = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		      System.err.println( e.getMessage() );  
		      e.printStackTrace();
		} finally {
			sessao.close();
		}
		return objSalvo;
	}

	public boolean alterar(Bean novoBean) {
		boolean objSalvo = false;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = sessao.beginTransaction();
			sessao.update(novoBean);
			transaction.commit();
			objSalvo = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		      System.err.println( e.getMessage() );  
		      e.printStackTrace();
		} finally {
			sessao.close();
		}
		return objSalvo;
	}
	
	public boolean apagar(Bean bean) throws SQLException {
		boolean objSalvo = false;
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = sessao.beginTransaction();
			sessao.delete(bean);
			transaction.commit();
			objSalvo = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return objSalvo;
	}

	public boolean apagar(long id) throws SQLException {
		Bean bean = null;
		bean = (Bean) get(id);
		return apagar(bean);
	}

	public Bean get(long id) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Bean bean = null;
		try {
			transaction = sessao.beginTransaction();
			bean = (Bean) sessao.get(classe, id);
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return bean;
	}

	public Bean get(String id) {
		return get(Long.parseLong(id));
	}

	public ArrayList<Bean> listar() {
		return listar("");
	}

	//FILTRA PALAVRA-CHAVE PELO NOME E ID
	public abstract ArrayList<Bean> listar(String filtro);

	public ArrayList<Bean> listarPor(int limite, String filtro) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Bean> beans = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from " + classe.getName();
			if (filtro != null && !filtro.equals("")) {
				try {
					hql_query += " where " + filtro;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (limite > 0) {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query)
						.setMaxResults(limite).list();
			}
			else {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query).list();
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
		return beans;
	}
	
	//FILTRA A CLAUSULA WHERE
	public ArrayList<Bean> listarPor(String filtro) {
		return listarPor(0, filtro);
	}
	
	/*
	 * FILTRO: CONDIÇÕES PARA FILTRAR
	 * CAMPO: CAMPO A ORDENAR
	 * ORDENA: 0 - ASC | 1 OU MAIOR DESC 
	 */
	public ArrayList<Bean> listarPor(String filtro, String campo, int ordena) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Bean> beans = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from " + classe.getName();
			if (campo == null || campo.equalsIgnoreCase("")) {
				campo = "id";
			}
			if (filtro != null && !filtro.equals("")) {
				try {
					hql_query += " where str(" + campo + ") like '%"+filtro+"%'";
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ordena == 0) {
				hql_query += " order by "+campo+" asc";
			} else {
				hql_query += " order by "+campo+" desc";
			}
			beans = (ArrayList<Bean>) sessao.createQuery(hql_query).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return beans;
	}

	public ArrayList<Bean> listarPor(String filtro, String campo, int ordena, int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Bean> beans = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from " + classe.getName();
			if (filtro != null && !filtro.equals("")) {
				try {
					hql_query += " where " + filtro;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ordena == 0) {
				hql_query += " order by "+campo+" asc";
			} else {
				hql_query += " order by "+campo+" desc";
			}
			if (limite > 0) {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query)
						.setMaxResults(limite).list();
			}
			else {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query).list();
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
		return beans;
	}
	public ArrayList<Bean> listarPor(String campo, int ordena, int limite) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Bean> beans = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from " + classe.getName();
			if (ordena == 0) {
				hql_query += " order by "+campo+" asc";
			} else {
				hql_query += " order by "+campo+" desc";
			}
			if (limite > 0) {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query)
						.setMaxResults(limite).list();
			}
			else {
				beans = (ArrayList<Bean>) sessao.createQuery(hql_query).list();
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
		return beans;
	}
	
	public ArrayList<Bean> listarPor(String campo, int ordena) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<Bean> beans = null;
		try {
			transaction = sessao.beginTransaction();
			String hql_query = "from " + classe.getName();
			if (ordena == 0) {
				hql_query += " order by "+campo+" asc";
			} else {
				hql_query += " order by "+campo+" desc";
			}
			beans = (ArrayList<Bean>) sessao.createQuery(hql_query).list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			sessao.close();
		}
		return beans;
	}

	public ArrayList<Bean> listar(long filtro) {
		return listar(String.valueOf(filtro));
	}
}