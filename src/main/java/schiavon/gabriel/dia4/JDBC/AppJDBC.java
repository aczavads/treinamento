package schiavon.gabriel.dia4.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppJDBC {
	private static final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			criarTabelaPessoa(conn);

			conn.setAutoCommit(false);
			insertPessoa(conn, ana);
			insertPessoa(conn, laura);
			insertPessoa(conn, rafaela);

			trocarDadosPessoa(ana, ana.getCodigo(), "Ana");
			updatePessoa(conn, ana);

			deletePessoa(conn, rafaela);
			conn.commit();

			List<Pessoa> pessoas = recuperarTodas(conn);
			pessoas.forEach(System.out::println);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("select id, codigo, nome from pessoa");
		
		while (rsPessoas.next()) {
			final Pessoa pessoa = new Pessoa(
					(UUID) rsPessoas.getObject("id"),
					rsPessoas.getInt("codigo"),
					rsPessoas.getString("nome"));
			
			pessoas.add(pessoa);
		}
		
		return pessoas;
	}

	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		deletePessoa(conn, pessoa.getId());
	}

	private static void deletePessoa(Connection conn, UUID id) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("delete from pessoa where id=?");
		psDelete.setObject(1, id);

		psDelete.execute();
	}

	private static void trocarDadosPessoa(Pessoa pessoa, int codigo, String nome) {
		pessoa.setCodigo(codigo);
		pessoa.setNome(nome);
	}

	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set codigo=?,nome=? where id=?");
		psUpdate.setInt(1, pessoa.getCodigo());
		psUpdate.setString(2, pessoa.getNome());
		psUpdate.setObject(3, pessoa.getId());

		psUpdate.executeUpdate();
	}

	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());

		psInsert.executeUpdate();
	}

	private static void criarTabelaPessoa(Connection conn) throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa (id uuid not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");
		conn.createStatement().execute("delete from pessoa");
	}

}
