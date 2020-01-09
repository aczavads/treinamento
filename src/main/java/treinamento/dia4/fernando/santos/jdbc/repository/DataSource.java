package treinamento.dia4.fernando.santos.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private final Connection connection;

	public DataSource() {
		try {
			this.connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
