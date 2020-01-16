package fernando_santos.treinamento.dia4.jdbc.repo_generico;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;

public class ConnectionPool {

	private final DataSource dataSource;

	public ConnectionPool() {
		this.dataSource = JdbcConnectionPool.create("jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
