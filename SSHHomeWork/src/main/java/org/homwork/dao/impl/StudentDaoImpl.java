package org.homwork.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.homwork.dao.StudentDao;
import org.homwork.pojo.Student;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {

	@Override
	public void add(Student student) {
		this.getHibernateTemplate().save(student);
	}

	@Override
	public void altStudent(Student student) {
		this.getHibernateTemplate().merge(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return this.getHibernateTemplate().execute( new HibernateCallback<List<Student>>() {

			@Override
			public List<Student> doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createQuery("from Student s left join fetch s.classes").list();
			}
		} );
	}

	@Override
	public void delete(Student student) {
		this.getHibernateTemplate().delete(student);
	}
}
