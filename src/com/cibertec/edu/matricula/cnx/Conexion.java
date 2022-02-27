package com.cibertec.edu.matricula.cnx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	//Conexi�n a MySQL
	
	//private static String url = "jdbc:mysql://cibertec.cepy5qnydcf5.us-east-1.rds.amazonaws.com:3306/cibertec";
	private static String url = "jdbc:mysql://localhost:3306/cibertec";
	private static String user = "root";
	private static String pass = "mysql";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection conn = null;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error de Driver: " + e.getMessage());
		}
	}
	
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			System.out.println("Error de conexi�n: " + e.getMessage());
		}
		
		return conn;
	}
}
