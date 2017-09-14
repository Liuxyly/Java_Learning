package org.homwork.biz.impl;

import java.util.List;

import org.homwork.biz.ClassesBiz;
import org.homwork.dao.ClassesDao;
import org.homwork.pojo.Classes;

public class ClassesBizImpl implements ClassesBiz {
	
	private ClassesDao classesDao;

	/**
	 * @return the classesDao
	 */
	public ClassesDao getClassesDao() {
		return classesDao;
	}

	/**
	 * @param classesDao the classesDao to set
	 */
	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public List<Classes> getAllClasses() {
		return classesDao.getAllClasses();
	}

}
