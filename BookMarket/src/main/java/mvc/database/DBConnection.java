package mvc.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException  {		

		
		Connection conn = null;		
	
		String url = "jdbc:mysql://192.168.111.101:3306/bookmarketdb";
		String user = "mbcBook";
		String password = "mbc1234";

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, password);		
		
		return conn;
		 }
}