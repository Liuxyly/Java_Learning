package org.liuxy.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
	public static final ThreadLocal<Session> SESSIONMAP = new ThreadLocal<Session>();

	private static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory;
	
	/**
	 * @return the sessionfactory
	 */
	public static synchronized SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	static {
		try {
			logger.debug("---------------------HibernateUti.static - loading cofig---------------------");
			sessionFactory = new Configuration().configure().buildSessionFactory();
			logger.debug("---------------------HibernateUtil.static - end---------------------");
		} catch (Throwable ex) {
			ex.printStackTrace();
			logger.error("---------------------HibernateUti error : ExceptionInInitializerError---------------------");
			throw new ExceptionInInitializerError(ex);
		}
	}

	private HibernateUtil() {
	}

	public static Session getSession() throws HibernateException {
		Session session = SESSIONMAP.get();

		if (session == null) {
			session = sessionFactory.openSession();
			SESSIONMAP.set(session);
		}

		return session;
	}

	public static void closeSession() throws HibernateException {
		Session session = SESSIONMAP.get();
		SESSIONMAP.set(null);

		if (session != null) {
			session.close();
		}
	}

}
