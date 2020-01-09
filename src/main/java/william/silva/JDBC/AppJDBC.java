package william.silva.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import william.silva.Repository.PessoaRepository;

public class AppJDBC {
	private final static Pessoa william = new Pessoa(1, "William D. Costa");
	private final static Pessoa douglas = new Pessoa(2, "Douglas C. Silva");
	private final static Pessoa lilian = new Pessoa(3, "Lilian L. Winckzuk");
	private final static Pessoa juliana = new Pessoa(4, "Juliana Silva");

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
			
			pessoaRepository.insert(william);
			pessoaRepository.insert(douglas);
			pessoaRepository.insert(lilian);
			pessoaRepository.insert(juliana);

			conn.commit();

			JOptionPane.showMessageDialog(null, "deletando...");
			pessoaRepository.delete(douglas);
			pessoaRepository.delete(lilian.getId());
			conn.commit();

			william.setNome("Will Douglas");
			JOptionPane.showMessageDialog(null, "alterando nome...");
			pessoaRepository.update(william);
			conn.commit();

			List<Pessoa> pessoas = pessoaRepository.selectAll();
			conn.commit();
			pessoas.forEach(p -> System.out.println(p));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
