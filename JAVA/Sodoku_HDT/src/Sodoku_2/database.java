package Sodoku_2;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class database {
//	try {
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		String connectionURL ="jdbc:sqlserver://DESKTOP-OH9IU5S\\SQLEXPRESS:1433;databaseName=testBD;integratedSecurity=true";
//		DriverManager.getConnection(connectionURL);
//		System.out.println("Kết nối SQL thành công");
//	} catch (ClassNotFoundException | SQLException ex) {
//		System.out.println("Kết nối SQL thất bại");
//		System.err.println(ex.getMessage()+ "\n"+e.getClass()+"\n"+ex.getCause());
//	}
	static String url ="jdbc:mysql://127.0.0.1:3306/sodokugame";
	static String user = "root";
	static String pass = "";
	private String nameDriver;
	public boolean loadDriver() {
		try {
			Class.forName(nameDriver);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
	public static void readData() {
	try {
		Connection myConn = DriverManager.getConnection(url,user,pass);
		Statement statement = myConn.createStatement();
		ResultSet rs = statement.executeQuery("Select*from game");
				
				while (rs.next()) {
					System.out.println(rs.getString("data"));
					
				}
	} catch (Exception ex) {
		ex.printStackTrace();
	}finally {
		statement.clos();
		Connection.close();
	}
	}
}
