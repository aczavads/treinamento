package fernando_santos.treinamento.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AppJDBCComRepository {
	private static final Pessoa fernandoSantos = new Pessoa(1, "Fernando Santos");
	private static final Pessoa paulaToledo = new Pessoa(2, "Paula Toledo");
	private static final Pessoa suelyMaria = new Pessoa(3, "Suely Maria");

	public static void main(String[] args) {
		try {
			Connection connection = new DataSource().getConnection();
			PessoaRepository pessoaRepository = new PessoaRepository(connection);

			pessoaRepository.createTable();
			pessoaRepository.insert(fernandoSantos);
			pessoaRepository.insert(paulaToledo);
			pessoaRepository.insert(suelyMaria);

//			JOptionPane.showMessageDialog(null, "Transação em curso...");

			paulaToledo.setNome("Paula");
			pessoaRepository.update(paulaToledo);

			pessoaRepository.delete(suelyMaria);
//			pessoaRepository.delete(fernandoSantos.getId());

			List<Pessoa> pessoas = pessoaRepository.selectAll();
			
			listAllPessoa(pessoas);

			connection.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static void listAllPessoa(List<Pessoa> pessoas) {
		pessoas.forEach(pessoa -> {
			System.out.println(pessoa);
		});
	}

}
