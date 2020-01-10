package valdenir.junior.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Duration;
import java.time.Instant;

public class AppTempo {
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
			conn.setAutoCommit(false);
			PessoaRepository repo = new PessoaRepository(conn);

			repo.createTable();
			Instant inicioA = Instant.now();
			for (int i = 0; i < 10000; i++) {
				repo.insert(new Pessoa(i, "A"));
			}
			conn.commit();
			System.out.println("Tempo total A: " + (Duration.between(inicioA, Instant.now()).toMillis()));

			repo.createTable();
			Instant inicioB = Instant.now();
			for (int i = 0; i < 10000; i++) {
				repo.insertPreparado(new Pessoa(i, "B"));
			}
			conn.commit();
			System.out.println("Tempo total B: " + (Duration.between(inicioB, Instant.now()).toMillis()));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
