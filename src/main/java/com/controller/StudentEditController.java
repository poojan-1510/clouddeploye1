package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.services.StudentServices;

public class StudentEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id=request.getParameter("sID");
		int sID=0;
		
		if(!id.equals("") || id!=null)
			sID=Integer.parseInt(id);
		
		
		StudentServices services=new StudentDao();
		
		List<StudentBean> students=services.getStudentsByID(sID);
		
		request.setAttribute("studentBean", students);
		
		request.getRequestDispatcher("StudentEdit.jsp").forward(request, response);
		
		
		
		
	}
}
