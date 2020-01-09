package schiavon.gabriel.dia4.JDBC.repository;

import java.sql.SQLException;
import java.util.List;

import schiavon.gabriel.dia4.JDBC.repository.MyConnection;
import schiavon.gabriel.dia4.JDBC.repository.PessoaRepository;

public class AppJDBCRepository {
	private static final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {
		try {
			PessoaRepository pessoaRepository = new PessoaRepository(MyConnection.getInstance());
			pessoaRepository.createTable();

			MyConnection.getInstance().setAutoCommit(false);
			pessoaRepository.insert(ana);
			pessoaRepository.insert(laura);
			pessoaRepository.insert(rafaela);

			trocarDadosPessoa(ana, ana.getCodigo(), "Ana");
			pessoaRepository.update(ana);

			pessoaRepository.delete(rafaela);
			MyConnection.getInstance().commit();

			List<Pessoa> pessoas = pessoaRepository.selectAll();
			pessoas.forEach(System.out::println);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static void trocarDadosPessoa(Pessoa pessoa, int codigo, String nome) {
		pessoa.setCodigo(codigo);
		pessoa.setNome(nome);
	}

}
