package GLF.dia4.jdbc;

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
	private static  final Pessoa ana = new Pessoa(1, "Ana Beatriz");
	private static final Pessoa laura = new Pessoa(2, "Laura");
	private static final Pessoa rafaela = new Pessoa(3, "Rafaela");
	
	public static void main (String[] args ) {
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			createTablePessoa(conn);
			conn.setAutoCommit(false);
			
			insertPessoa(conn,ana);
			insertPessoa(conn, laura);
			insertPessoa(conn, rafaela);
			
			JOptionPane.showMessageDialog(null, "Transação em curso...");
			conn.commit();
			
			
			ana.setNome("Ana");
			updatePessoa(conn, ana);
			
			deletePessoa(conn, rafaela);
			deletePessoa(conn, rafaela.getId());
			
			conn.commit();
			
			List<Pessoa> pessoas = recuperarTodas(conn);
			pessoas.forEach(p -> System.out.println(p));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Fim!");
	}
	
	private static List<Pessoa> recuperarTodas(Connection conn) throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoa = conn.createStatement().executeQuery("select id, codigo, nome from pessoa");
		
		while (rsPessoa.next()) {
			UUID idRecuperado = (UUID)rsPessoa.getObject("id");
			String nomeRecuperado = rsPessoa.getString("nome");
			Integer codigoRecuperado = rsPessoa.getInt("codigo");
			Pessoa recuperada = new Pessoa (idRecuperado, codigoRecuperado, nomeRecuperado);
			pessoas.add(recuperada);
		}
		return pessoas;
	}

	private static void updatePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
		
	}
	
	private static void deletePessoa(Connection conn, UUID id ) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("delete from pessoa where id = ? ");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
	}
	
	private static void deletePessoa(Connection conn, Pessoa pessoa) throws SQLException {
		deletePessoa(conn, pessoa.getId());
		
	}

	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}

	private static void createTablePessoa(Connection conn) throws SQLException { 
		conn.createStatement().execute("create table if not exists pessoa ("
				+ "id uuid not null primary key,"
				+"codigo integer not null unique,"
				+ "nome varchar(255) not null" 
				+ ")" );
		
		conn.createStatement().execute("delete from pessoa");
		
	}
}
