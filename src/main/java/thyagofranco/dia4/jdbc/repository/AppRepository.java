package thyagofranco.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

public class AppRepository {

	private static final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

			PessoaRepository repo = new PessoaRepository(conn);

			repo.createTable();
			conn.setAutoCommit(false);

			repo.insert(ana);
			repo.insert(laura);
			repo.insert(rafaela);

			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conn.commit();

			ana.setNome("Ana");
			repo.update(ana);
			repo.delete(rafaela.getId());
			repo.delete(laura);
			conn.commit();

			List<Pessoa> pessoas = repo.selectAll();
			pessoas.forEach(p -> System.out.println(p));
			
			

		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}
		
		
		
		
		System.out.println("Fim.");

	}

}
