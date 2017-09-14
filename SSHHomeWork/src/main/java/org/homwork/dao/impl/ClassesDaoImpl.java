package org.homwork.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.homwork.dao.ClassesDao;
import org.homwork.pojo.Classes;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

	@Override
	public List<Classes> getAllClasses() {
		return this.getHibernateTemplate().execute( new HibernateCallback<List<Classes>>() {

			@Override
			public List<Classes> doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery("from Classes").list();
			}
		} );
	}

}
