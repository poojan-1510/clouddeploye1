package com.services;

import java.util.List;

import com.bean.StudentBean;

public interface StudentServices 
{
	public boolean addStudents(StudentBean studentBean);
	public List<StudentBean> viewStudents();
	public List<StudentBean> getStudentsByID(int sID);
	public boolean deleteStudent(int sID);
	public boolean updateStudent(StudentBean bean);
}
