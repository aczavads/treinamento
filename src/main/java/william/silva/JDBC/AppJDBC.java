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

public class AppJDBC {
	private final static Pessoa william = new Pessoa(1, "William D. Costa");
	private final static Pessoa douglas = new Pessoa(2, "Douglas C. Silva");
	private final static Pessoa lilian = new Pessoa(3, "Lilian L. Winckzuk");
	private final static Pessoa juliana = new Pessoa(4, "Juliana Silva");

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
			createTablePessoa(conn);
			conn.setAutoCommit(false);
			insertPessoa(conn, william);
			insertPessoa(conn, douglas);
			insertPessoa(conn, lilian);
			insertPessoa(conn, juliana);
			
			conn.commit();
			
			JOptionPane.showMessageDialog(null, "deletando...");
			deletePessoa(conn, douglas);
			deletePessoa(conn, lilian.getId());
			conn.commit();
			
			william.setNome("Will Douglas");
			JOptionPane.showMessageDialog(null, "alterando nome...");
			updateNomePessoa(conn, william);
			conn.commit();
			
			List<Pessoa> pessoas = recuperarTodas(conn);
			conn.commit();
			pessoas.forEach(p -> System.out.println(p));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("Select id, codigo, nome from pessoa");
		while (rsPessoas.next()) {
			Pessoa pessoaRecuperada = new Pessoa(
					(UUID)rsPessoas.getObject("id"),
					rsPessoas.getInt("codigo"),
					rsPessoas.getString("nome"));
			pessoas.add(pessoaRecuperada);
		}
		return pessoas;
	}
	private static void deletePessoa(Connection conn, UUID id) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?;");
		psDelete.setObject(1, id);
		psDelete.execute();
		
	}

	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		deletePessoa(conn, pessoa.getId());
		
		
	}

	private static void updateNomePessoa(Connection conn, Pessoa william) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, william.getNome());
		psUpdate.setInt(2, william.getCodigo());
		psUpdate.setObject(3, william.getId());
		psUpdate.executeUpdate();
	}

	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome)" + "values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}

	private static void createTablePessoa(Connection conn) throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa(" + "id UUID not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");

		conn.createStatement().execute("delete from pessoa");
	}
}
