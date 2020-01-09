package schiavon.gabriel.dia4.JDBC.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	private static Connection conn;
	
	private MyConnection() {}
	
	public static Connection getInstance() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Nao foi possivel estabelecer conexão com o banco de dados");
			}
		}
		
		return conn;
	}
	
}
