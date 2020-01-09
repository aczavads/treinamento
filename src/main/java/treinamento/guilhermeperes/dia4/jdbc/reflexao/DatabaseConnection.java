package treinamento.guilhermeperes.dia4.jdbc.reflexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static Connection conn;
	
	private DatabaseConnection() {
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
			} catch (SQLException e) {
				throw new RuntimeException("Cannot connect on database");
			}
		}
		
		return conn;
	}
}
