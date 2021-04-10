package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.dao.StudentDao;
import com.services.StudentServices;

public class StudentUpateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		String sName = request.getParameter("txtStudentName");
		String sEmail = request.getParameter("txtStudentEmail");
		String sPassword = request.getParameter("pwdStudentPassword");
		String age = request.getParameter("txtStudentAge");
		String id = request.getParameter("sID");

		int sAge = 0;

		if (!age.trim().equals("") || !age.equals(null)) {
			sAge = Integer.parseInt(age);
		}

		else {
			System.out.println("Invalid age");
		}
		int sId = 0;

		if (!id.trim().equals("") || !id.equals(null)) {
			sId = Integer.parseInt(id);
		}
		StudentBean studentBean = new StudentBean();

		studentBean.setsName(sName);
		studentBean.setsMail(sEmail);
		studentBean.setsPassword(sPassword);
		studentBean.setsAge(sAge);
		studentBean.setsId(sId);

		StudentServices services = new StudentDao();

		if (services.updateStudent(studentBean)) {
			request.setAttribute("msg", "updated");
			request.getRequestDispatcher("studentdisplaycontroller").forward(request, response);
		}

		else {
			request.setAttribute("msg", "update failed");
			request.getRequestDispatcher("studentdisplaycontroller").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
