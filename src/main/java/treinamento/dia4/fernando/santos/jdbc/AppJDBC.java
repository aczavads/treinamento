package treinamento.dia4.fernando.santos.jdbc;

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
	private static final Pessoa fernandoSantos = new Pessoa(1, "Fernando Santos");
	private static final Pessoa paulaToledo = new Pessoa(2, "Paula Toledo");
	private static final Pessoa suelyMaria = new Pessoa(3, "Suely Maria");

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");

			createTablePessoa(conn);
			insertPessoa(conn, fernandoSantos);
			insertPessoa(conn, paulaToledo);
			insertPessoa(conn, suelyMaria);

			JOptionPane.showMessageDialog(null, "Transação em curso...");

			paulaToledo.setNome("Paula");
			updatePessoa(conn, paulaToledo);

			deletePessoa(conn, suelyMaria);
//			deletePessoa(conn, fernandoSantos.getId());

			List<Pessoa> pessoas = selectAllPessoa(conn);
			
			listAllPessoa(pessoas);

			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static void listAllPessoa(List<Pessoa> pessoas) {
		pessoas.forEach(pessoa -> {
			System.out.println(pessoa);
		});
	}

	private static List<Pessoa> selectAllPessoa(Connection conn) throws SQLException {
		ResultSet rs = conn.createStatement().executeQuery("select id, codigo, nome from pessoa");
		List<Pessoa> pessoas = new ArrayList<>();
		while (rs.next()) {
			Pessoa pessoaRecuperada = new Pessoa((UUID) rs.getObject("id"), rs.getInt("codigo"), rs.getString("nome"));
			pessoas.add(pessoaRecuperada);
		}
		return pessoas;
	}

	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		deletePessoa(conn, pessoa.getId());
	}

	private static void deletePessoa(Connection conn, UUID id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from pessoa where id = ?");
		ps.setObject(1, id);
		ps.execute();
	}

	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		ps.setString(1, pessoa.getNome());
		ps.setInt(2, pessoa.getCodigo());
		ps.setObject(3, pessoa.getId());
		ps.executeUpdate();
	}

	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?, ?, ?)");
		ps.setObject(1, pessoa.getId());
		ps.setInt(2, pessoa.getCodigo());
		ps.setString(3, pessoa.getNome());
		ps.executeUpdate();
	}

	private static void createTablePessoa(Connection conn) throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa (" + "id uuid not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null)");
	}
}
