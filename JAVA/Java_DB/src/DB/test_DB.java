package DB;

import java.sql.DriverManager;
import java.sql.SQLException;

public class test_DB {
	public static void main(String[] args) throws SQLException {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL ="jdbc:sqlserver://DESKTOP-OH9IU5S\\SQLEXPRESS:1433;databaseName=testBD;integratedSecurity=true";
			DriverManager.getConnection(connectionURL);
			System.out.println("Kết nối SQL thành công");
		} catch (ClassNotFoundException e) {
			System.out.println("Kết nối SQL thất bại");
			System.err.println(e.getMessage()+ "\n"+e.getClass()+"\n"+e.getCause());
		}
	}
}
