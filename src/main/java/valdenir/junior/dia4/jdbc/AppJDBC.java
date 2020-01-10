package valdenir.junior.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class AppJDBC {
	private static final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
//			conn.setAutoCommit(false);
//			conn.commit();

			PessoaRepository pessoaRepository = new PessoaRepository(conn);
			pessoaRepository.createTable();
			pessoaRepository.insert(ana);
			pessoaRepository.insert(laura);
			pessoaRepository.insert(rafaela);

			ana.setNome("Ana");
			pessoaRepository.update(ana);

			pessoaRepository.delete(rafaela);

			List<Pessoa> pessoas = pessoaRepository.selectAll();
			pessoas.forEach(pessoa -> System.out.println(pessoa));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("FIM.");
	}
}
