package co.micol.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao { //static Class로 만듬, jvm이 생성자안쓰면 알아서 올려줌.
	public static Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "demo";
		String password = "1234";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
