package treinamento.diegomucheniski.dia4.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import treinamento.diegomucheniski.domains.Pessoa;

public class PessoaRepository {
	
	private static Connection conexao;
	
	public PessoaRepository(Connection conexao) throws SQLException {
		this.conexao = conexao;
	}
	
	public static List<Pessoa> findAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		String sqlSelect = " SELECT ID, CODIGO, NOME FROM PESSOA ";
		ResultSet rsPessoas = conexao.createStatement().executeQuery(sqlSelect);
		
		while (rsPessoas.next()) {
			
			UUID idRetornado = (UUID)rsPessoas.getObject("id");
			Integer codigoRecuperado = rsPessoas.getInt("codigo");
			String nomeRetornado = rsPessoas.getString("nome");
			
			Pessoa pessoa = new Pessoa(idRetornado, codigoRecuperado, nomeRetornado);
			pessoas.add(pessoa);
		}		
		return pessoas;
	}

	public static void createTable() throws SQLException {		
		String sqlCreate = " CREATE TABLE if not exists pessoa ("
						 + " id uuid not null primary key,"
						 + " codigo integer not null unique,"
						 + " nome varchar(255) not null"
					     + ")";
		
		conexao.createStatement().execute(sqlCreate);	
		conexao.createStatement().execute("DELETE FROM PESSOA");
	}

	public static void insert(Pessoa pessoa) throws SQLException {		
		String sqlInsert = "INSERT INTO PESSOA(id, codigo, nome) values (?, ?, ?)";		
		PreparedStatement psInsert = conexao.prepareStatement(sqlInsert);
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	public static void insert(Pessoa pessoa, PreparedStatement psInsert) throws SQLException {		
		String sqlInsert = "INSERT INTO PESSOA(id, codigo, nome) values (?, ?, ?)";		
		psInsert = conexao.prepareStatement(sqlInsert);
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	public static void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());	
	}
	
	public static void delete(UUID idPessoa) throws SQLException {
		String sqlDelete = " DELETE FROM PESSOA WHERE id = ?";
		PreparedStatement psDelete = conexao.prepareStatement(sqlDelete);
		psDelete.setObject(1, idPessoa);
		psDelete.executeUpdate();		
	}
	
	public static void update(Pessoa pessoa) throws SQLException {
		String sqlUpdate = " UPDATE PESSOA SET NOME = ?, codigo = ? WHERE id = ?";
		PreparedStatement psUpdate = conexao.prepareStatement(sqlUpdate);
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();			
	}

}
