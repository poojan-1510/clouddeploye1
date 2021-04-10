package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.services.StudentServices;

/**
 * Servlet implementation class StudentRegisterationController
 */
public class StudentRegisterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String sName=request.getParameter("txtStudentName");
		String sEmail=request.getParameter("txtStudentEmail");
		String sPassword=request.getParameter("pwdStudentPassword");
		String age=request.getParameter("txtStudentAge");
		
		int sAge=0;
		
		if(!age.trim().equals("") || !age.equals(null))
		{
			sAge=Integer.parseInt(age);
		}
		
		else
		{
			System.out.println("Invalid age");
		}
	
		StudentBean studentBean=new StudentBean();
		
		studentBean.setsName(sName);
		studentBean.setsMail(sEmail);
		studentBean.setsPassword(sPassword);
		studentBean.setsAge(sAge);
		
		StudentServices services=new StudentDao();
		
		if(services.addStudents(studentBean))
		{
			request.getRequestDispatcher("sucess.jsp").forward(request, response);
		}
		
		else
		{
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
}
