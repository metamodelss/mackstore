package com.mackstore.admin.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sf;
	static{
		try {
			sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable erro) {
			System.err.println("Falha ao inicializar o SessionFactory.\n"+erro);
			throw new ExceptionInInitializerError(erro);
		}
	}

	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	public static boolean close(){
		try {
			sf.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
