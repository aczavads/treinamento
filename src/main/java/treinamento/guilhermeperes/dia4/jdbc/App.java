package treinamento.guilhermeperes.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class App {
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "")) {
			createTables(conn);
			insertPessoa(conn, new Pessoa(1, "Guilherme Beidaki"));
			insertPessoa(conn, new Pessoa(2, "Ana Luisa"));
			insertPessoa(conn, new Pessoa(3, "Paulo Peres"));
			insertPessoa(conn, new Pessoa(4, "Cristina Beidaki"));
			insertPessoa(conn, new Pessoa(5, "Flavio Peres"));
			
			updatePessoa(conn, new Pessoa(1, "Guilherme"));
			
			deletePessoa(conn, 5);
			
			selectPessoas(conn).forEach(pessoa -> System.out.println(pessoa.getNome()));
			System.out.println(selectPessoa(conn, 1).getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void createTables(Connection conn) throws SQLException {
		PreparedStatement pessoaTable = conn.prepareStatement("CREATE TABLE PESSOA("
				+ "ID UUID PRIMARY KEY,"
				+ "CODIGO INTEGER UNIQUE NOT NULL,"
				+ "NOME VARCHAR(40) NOT NULL)");
		
		pessoaTable.execute();
	}
	
	private static Pessoa selectPessoa(Connection conn, Integer codigo) throws SQLException {
		PreparedStatement select = conn.prepareStatement("SELECT ID, CODIGO, NOME FROM PESSOA WHERE CODIGO = ?");
		
		select.setInt(1, codigo);
		
		ResultSet result = select.executeQuery();
		
		if (result.next()) {
			return new Pessoa((UUID) result.getObject("ID"), result.getInt("CODIGO"), result.getString("NOME"));
		}
		
		return null;
				
	}
	
	private static List<Pessoa> selectPessoas(Connection conn) throws SQLException {
		List<Pessoa> list = new ArrayList<Pessoa>();
		
		PreparedStatement select = conn.prepareStatement("SELECT ID, CODIGO, NOME FROM PESSOA");
		
		ResultSet result = select.executeQuery();
		
		while(result.next()) {
			list.add(new Pessoa((UUID) result.getObject("ID"), result.getInt("CODIGO"), result.getString("NOME")));
		}
		
		return list;
	}
	
	private static void insertPessoa(Connection conn, Pessoa pessoa) throws SQLException {
		PreparedStatement insert = conn.prepareStatement("INSERT INTO PESSOA VALUES (?, ?, ?)");
		
		insert.setObject(1, pessoa.getId());
		insert.setInt(2, pessoa.getCodigo());
		insert.setString(3, pessoa.getNome());
		
		insert.execute();
	}
	
	private static void updatePessoa(Connection conn ,Pessoa pessoa) throws SQLException {
		PreparedStatement update = conn.prepareStatement("UPDATE PESSOA SET NOME = ? WHERE CODIGO = ?");
		
		update.setString(1, pessoa.getNome());
		update.setInt(2, pessoa.getCodigo());
		
		update.execute();
	}
	
	private static void deletePessoa(Connection conn, Integer codigo) throws SQLException {
		PreparedStatement delete = conn.prepareStatement("DELETE FROM PESSOA WHERE CODIGO = ?");
		
		delete.setInt(1, codigo);
		
		delete.execute();
	}
}
