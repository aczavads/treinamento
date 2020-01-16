package william.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

import william.JDBC.Pessoa;

public class AppPreparedStatement {
	private final static Pessoa william = new Pessoa(1, "William D. Costa");

	public static void main(String[] args) {
		Connection conn;
		PessoaRepository pessoaRepository;
		try {
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			pessoaRepository = new PessoaRepository(conn);
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		try {
			
			pessoaRepository.createTable();
			
			
			
			Instant started = Instant.now();
			for (int i = 0; i < 500000; i++) {
				pessoaRepository.insert1(new Pessoa(i + 1, "William D. Costa"));
			}
			conn.commit();
			Instant finish = Instant.now();
			
			System.out.println("tempo de execução: "+Duration.between(started, finish).toMillis());
			
			
			pessoaRepository.createTable();
			 started = Instant.now();
			for (int i = 0; i < 500000; i++) {
				pessoaRepository.insert(new Pessoa(i + 1, "William D. Costa"));
			}
			conn.commit();
			 finish = Instant.now();
			
			System.out.println("tempo de execução: "+Duration.between(started, finish).toMillis());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Fim");

	}
}
