package org.homwork.dao;

import java.util.List;

import org.homwork.pojo.Student;

public interface StudentDao {
	void add(Student student);
	void delete(Student student);
	void altStudent(Student student);
	List<Student> getAllStudents();
}
