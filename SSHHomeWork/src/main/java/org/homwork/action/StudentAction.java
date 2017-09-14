package org.homwork.action;

import java.util.ArrayList;
import java.util.List;

import org.homwork.biz.ClassesBiz;
import org.homwork.biz.StudentBiz;
import org.homwork.pojo.Classes;
import org.homwork.pojo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1816330201791025003L;
	private Student student;
	private List<Student> listStudents;
	private StudentBiz studentBiz;
	private ClassesBiz classesBiz;
	private List<Classes> listClasses = new ArrayList<>();
	
	/**
	 * @return the listClasses
	 */
	public List<Classes> getListClasses() {
		return listClasses;
	}

	/**
	 * @param listClasses the listClasses to set
	 */
	public void setListClasses(List<Classes> listClasses) {
		this.listClasses = listClasses;
	}

	/**
	 * @return the classesBiz
	 */
	public ClassesBiz getClassesBiz() {
		return classesBiz;
	}

	/**
	 * @param classesBiz the classesBiz to set
	 */
	public void setClassesBiz(ClassesBiz classesBiz) {
		this.classesBiz = classesBiz;
	}

	/**
	 * @return the studentBiz
	 */
	public StudentBiz getStudentBiz() {
		return studentBiz;
	}

	/**
	 * @param studentBiz the studentBiz to set
	 */
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}

	/**
	 * @return the listStudents
	 */
	public List<Student> getListStudents() {
		return listStudents;
	}

	/**
	 * @param listStudents the listStudents to set
	 */
	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String listStudent(){
		listStudents = studentBiz.getAllStudent();
		return "listStudent";
	}

	public String toAdd() {
		listClasses = classesBiz.getAllClasses();
		return SUCCESS;
	}
	
	public String add() {
		studentBiz.addStudent(student);
		return SUCCESS;
	}
}
