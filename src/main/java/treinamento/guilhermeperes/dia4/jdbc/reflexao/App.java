package treinamento.guilhermeperes.dia4.jdbc.reflexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class App {
	public static void main(String[] args) {
		try {
			createTables(DatabaseConnection.getConnection());
			
			PessoaRepository repo = new PessoaRepository();
			
			Pessoa gui = new Pessoa(UUID.fromString("0420a527-cc38-4c40-b596-cd9e878bcce3"), 1, "Guilherme Beidaki Peres");
			
			repo.insertOne(gui);
			repo.insertOne(new Pessoa(2, "Ana Luisa Beidaki"));
			repo.insertOne(new Pessoa(3, "Paulo Peres"));
			repo.insertOne(new Pessoa(4, "Cristina Beidaki"));
			repo.insertOne(new Pessoa(UUID.fromString("5ffc4a9e-a068-4c95-baab-44d668d9d26c"), 5, "Flavio Peres"));
			
			repo.deleteById(UUID.fromString("5ffc4a9e-a068-4c95-baab-44d668d9d26c"));
			
			repo.selectAll().forEach(System.out::println);
			
			repo.updateById(new Pessoa(UUID.fromString("0420a527-cc38-4c40-b596-cd9e878bcce3"), 1, "Guilherme"));
			
			repo.selectAll().forEach(System.out::println);
		} catch (SQLException e) {
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
}
