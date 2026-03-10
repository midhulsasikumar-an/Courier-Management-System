package DB;

import java.sql.*;
public class DBC {
	public static Connection get_Connection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Courier" , "root" , "root");
			if(conn != null) {
				System.out.println("Database Connected!");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
}
