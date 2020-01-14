package treinamento.matheusfaxina.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Jdbc {

	private final static Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private final static Pessoa laura = new Pessoa(2, "Laura");
	private final static Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			PessoaRepository pessoaRepository = new PessoaRepository(conn);
					
			Instant started = Instant.now();
			pessoaRepository.createTable("pessoa");
			for (int i = 1; i < 10000; i++) {
				conn.setAutoCommit(false);
				//pessoaRepository.insertComPrepareStatementDentro(new Pessoa(i, "Teste"));
				pessoaRepository.insertComPrepareStatementFora(new Pessoa(i, "Teste"));
				conn.commit();
			}
			Instant finish = Instant.now();
			System.out.println("Tempo total Fora: " + Duration.between(started, finish).toMillis());
			
			Instant started1 = Instant.now();
			pessoaRepository.createTable("pessoa");
			for (int i = 1; i < 10000; i++) {
				conn.setAutoCommit(false);
				//pessoaRepository.insertComPrepareStatementDentro(new Pessoa(i, "Teste"));
				pessoaRepository.insertComPrepareStatementDentro(new Pessoa(i, "Teste"));
				conn.commit();
			}
			Instant finish1 = Instant.now();
			System.out.println("Tempo total Dentro: " + Duration.between(started1, finish1).toMillis());
			
//			conn.setAutoCommit(false);
//			pessoaRepository.insert(ana);
//			pessoaRepository.insert(laura);
//			pessoaRepository.insert(rafaela);
//
//			ana.setNome("Ana");
//			pessoaRepository.update(ana);
//			pessoaRepository.delete(rafaela);
//
//			List<Pessoa> pessoas = pessoaRepository.selectAll();
//			pessoas.forEach(pessoa -> System.out.println(pessoa));
//			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
