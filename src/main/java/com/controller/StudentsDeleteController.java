package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.services.StudentServices;

public class StudentsDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Id=request.getParameter("sID");
		int sID=Integer.parseInt(Id);
		
		StudentServices services=new StudentDao();
		
		if(services.deleteStudent(sID))
		{
			response.sendRedirect("studentdisplaycontroller");
		}
		else
		{
			response.sendRedirect("studentdisplaycontroller");
		}
	}
}
