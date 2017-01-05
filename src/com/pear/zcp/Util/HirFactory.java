package com.pear.zcp.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HirFactory {

	public static SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}
	
}
