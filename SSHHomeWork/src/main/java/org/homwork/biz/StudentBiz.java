package org.homwork.biz;

import java.util.List;

import org.homwork.pojo.Student;

public interface StudentBiz {
	List<Student> getAllStudent();
	void addStudent(Student student);
}
