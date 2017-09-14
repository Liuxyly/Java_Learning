package org.homwork.biz.impl;

import java.util.List;

import org.homwork.biz.StudentBiz;
import org.homwork.dao.StudentDao;
import org.homwork.pojo.Student;

public class StudentBizImpl implements StudentBiz {
	
	private StudentDao studentDao;
	
	/**
	 * @return the studentDao
	 */
	public StudentDao getStudentDao() {
		return studentDao;
	}

	/**
	 * @param studentDao the studentDao to set
	 */
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudent() {
		return studentDao.getAllStudents();
	}

	@Override
	public void addStudent(Student student) {
		studentDao.add(student);
	}

}
