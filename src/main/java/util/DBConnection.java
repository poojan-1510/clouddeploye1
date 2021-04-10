package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String userName = "root";
	static String password = "root";
	static String connectionURL = "jdbc:mysql://localhost:3306/advJava";
	static String driverClass = "com.mysql.cj.jdbc.Driver";

	static Connection conn;

	public  static Connection getDBConnection() {
		try {
			Class.forName(driverClass);
			
			conn=DriverManager.getConnection(connectionURL, userName, password);
			
			if(conn!=null)
			{
				System.out.println("DataBase connected ... ");
				
				return conn;
			}
			else
			{
				System.out.println("Connection failed ... ");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
