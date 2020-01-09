package treinamento.dia4.fernando.santos.jdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;

public class PreparedStatementPerformanceTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = new DataSource().getConnection();
		PessoaRepositoryComPreparedStatementPorInsert pessoaRepositoryComPreparedStatementPorInsert 
			= new PessoaRepositoryComPreparedStatementPorInsert(connection);
		PessoaRepository pessoaRepository = new PessoaRepository(connection);

		connection.setAutoCommit(false);
		pessoaRepositoryComPreparedStatementPorInsert.createTable();

		pessoaRepositoryComPreparedStatementPorInsert.deleteAll();

		long inicio = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			Pessoa pessoa = new Pessoa(i, "");
			pessoaRepositoryComPreparedStatementPorInsert.insert(pessoa);
		}
		connection.commit();
		long fim = System.currentTimeMillis();
		System.out.println("Tempo 1: " + (fim - inicio) + " milissegundos com PreparedStatement instanciado a cada insert.");

		pessoaRepositoryComPreparedStatementPorInsert.deleteAll();
//		List<Pessoa> selectAll = pessoaRepositoryComPreparedStatementPorInsert.selectAll();
//		System.out.println("Tamanho após deletar todos: " + selectAll.size());

		inicio = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			Pessoa pessoa = new Pessoa(i, "");
			pessoaRepository.insert(pessoa);
		}
		connection.commit();
		fim = System.currentTimeMillis();
		System.out.println("Tempo 2: " + (fim - inicio) + " milissegundos com PreparedStatement instanciado no construtor.");
	}
}
