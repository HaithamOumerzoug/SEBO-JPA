package sebo.haitham_said.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con=DriverManager.getConnection("jdbc:mysql://mysql-27517-0.cloudclusters.net:27520/sebo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","rootroot");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sebo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static void setConnection(Connection connection) {
		con=connection;
	}
}
