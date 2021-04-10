package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.services.StudentServices;

import util.DBConnection;

public class StudentDao implements StudentServices {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;

	public boolean addStudents(StudentBean studentBean) {
		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String insertQuery = "insert into students(s_name,s_email,s_password,s_age) values(?,?,?,?)";

			try {
				pstm = conn.prepareStatement(insertQuery);

				pstm.setString(1, studentBean.getsName());
				pstm.setString(2, studentBean.getsMail());
				pstm.setString(3, studentBean.getsPassword());
				pstm.setInt(4, studentBean.getsAge());

				int res = pstm.executeUpdate();

				if (res > 0) {
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else {
			System.out.println("Connection failed .... ");
		}
		return false;
	}

	public List<StudentBean> viewStudents() {
		List<StudentBean> students = new ArrayList<StudentBean>();
		StudentBean studs = null;
		conn = DBConnection.getDBConnection();

		if (conn != null) {
			String display = "select * from students";

			try {
				pstm = conn.prepareStatement(display);

				rs = pstm.executeQuery();

				while (rs.next()) {
					studs = new StudentBean();

					studs.setsId(rs.getInt("s_id"));
					studs.setsName(rs.getString("s_name"));
					studs.setsMail(rs.getString("s_email"));
					studs.setsAge(rs.getInt("s_age"));

					students.add(studs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return students;
	}

	public boolean deleteStudent(int sID) {

		conn = DBConnection.getDBConnection();
		if (conn != null) {
			String delete = "delete from students where s_id=?";

			try {
				pstm = conn.prepareStatement(delete);

				pstm.setInt(1, sID);

				int res = pstm.executeUpdate();

				if (res > 0) {
					return true;
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateStudent(StudentBean bean) {

		conn = DBConnection.getDBConnection();

		if (conn != null) {

			
			String update = "update students set s_name=? , s_email=?, s_password=?,s_age=? where s_id = ?";

			try {
				pstm = conn.prepareStatement(update);

				pstm.setString(1, bean.getsName());
				pstm.setString(2, bean.getsMail());
				pstm.setString(3, bean.getsPassword());
				pstm.setInt(4, bean.getsAge());
				pstm.setInt(5, bean.getsId());

				int res = pstm.executeUpdate();

				if (res > 0)
					return true;
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return false;
	}

	public List<StudentBean> getStudentsByID(int sID) 
	{
		List<StudentBean> list=new ArrayList<StudentBean>();
		
		conn = DBConnection.getDBConnection();
		StudentBean studentBean = null;
		if (conn != null) {

			String selectSQL = "select * from student where eid =?";

			try {
				pstm = conn.prepareStatement(selectSQL);
				pstm.setInt(1, sID);
				ResultSet rs = pstm.executeQuery();

				while (rs.next()) {

					studentBean = new StudentBean();
					studentBean.setsId(rs.getInt(1));
					studentBean.setsName(rs.getString(2));
					studentBean.setsMail(rs.getString(3));
					studentBean.setsPassword(rs.getString(4));
					studentBean.setsAge(rs.getInt(5));

				}

			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
