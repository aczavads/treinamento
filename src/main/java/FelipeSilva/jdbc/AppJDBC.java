package FelipeSilva.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

public class AppJDBC {
	private static final Pessoa Ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa Laura = new Pessoa(2, "Laura");
	private static final Pessoa Rafaela = new Pessoa(3, "Rafaela");

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			createTablePessoa(conn);
			conn.setAutoCommit(false);
			insertPessoa(conn, Ana);
			insertPessoa(conn, Laura);
			insertPessoa(conn, Rafaela);
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			Ana.setNome("Ana");
			updatePessoa(conn, Ana);
			deletePessoa(conn, Rafaela);
			conn.commit();
			List<Pessoa> pessoas = recuperarTodas(conn);
			pessoas.forEach(p -> System.out.println(p));
		} catch (Exception erro) {
			throw new RuntimeException(erro);
		}
	}

	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id,codigo,nome) values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}

	private static void createTablePessoa(Connection conn) throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa (" + "id uuid not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");
		conn.createStatement().execute("delete from pessoa");

	}

	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
	}

	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("select id,codigo,nome from pessoa");
		while (rsPessoas.next()) {
			Pessoa recuperada = new Pessoa((UUID) rsPessoas.getObject("id"), rsPessoas.getInt("codigo"),
					rsPessoas.getString("nome"));
			pessoas.add(recuperada);
		}
		return pessoas;
	}

	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("delete from pessoa where id = ?");
		psDelete.setObject(1, pessoa.getId());
		;
		psDelete.executeUpdate();
	}
}
