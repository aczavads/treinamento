package schiavon.gabriel.dia4.JDBC.repository;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

public class AppPreparedStatementDesempenho {

	public static void main(String[] args) throws SQLException {
		PessoaRepository pessoaRepository = new PessoaRepository(MyConnection.getInstance());
		pessoaRepository.deleteAll();
		MyConnection.getInstance().setAutoCommit(false);
		Instant inicio = Instant.now();
		pessoaRepository.insertSemPreparedStatement();
		Instant fim = Instant.now();
		System.out.println("Tempo total SEM => " + Duration.between(inicio, fim));
		
		Instant inicio1 = Instant.now();
		for (int i=10001; i < 20000; i++) {
			pessoaRepository.insert(new Pessoa(i, "nome" + i));
			MyConnection.getInstance().commit();
		}
		Instant fim2 = Instant.now();
		System.out.println("Tempo total COM => " + Duration.between(inicio1, fim2));
	}
	
}
