package treinamento.thyagofranco.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.swing.JOptionPane;

public class AppRepositoryTesteStatment {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			PessoaRepository repo = new PessoaRepository(conn);
			PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
			conn.setAutoCommit(false);
			
			
			repo.createTable();
			conn.commit();
			Instant started = Instant.now();
			
			for (int i = 0; i < 10000; i++) {
				repo.insert(new Pessoa(i, "Thyago"));
			}
			
			Instant finished = Instant.now();
			System.out.println("Preparando a cada vez " + Duration.between(started, finished).toMillis());
			conn.commit();

			
			
			repo.createTable();
			conn.commit();
			started = Instant.now();
			for (int i = 0; i < 10000; i++) {
				repo.insert(new Pessoa(i, "Thyago"), psInsert);
			}
			finished = Instant.now();
			System.out.println("Preparando uma vez só " + Duration.between(started, finished).toMillis());
			conn.commit();
			//JOptionPane.showMessageDialog(null, "Transação em curso...");
		

		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}

		System.out.println("Fim.");

	}

}
