package giovani.bueno.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import giovani.bueno.jdbc.Pessoa;

public class PessoaRepository {
	
	private Connection conn;
		
	public PessoaRepository(Connection conn) {
		this.conn = conn;
	}
	
	public void insert(Pessoa pessoa) throws SQLException {
		
		PreparedStatement psInsert = conn.prepareStatement(
				"insert into pessoa(id,codigo,nome) values(?,?,?)"); 
		
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3,pessoa.getNome());
		psInsert.executeUpdate();
		
	}
	public void update(Pessoa pessoa) throws SQLException {
		
		PreparedStatement psUpdate = conn.prepareStatement(
				"update pessoa set nome=?, codigo = ? where id=?");
		psUpdate.setString(1,pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		
		psUpdate.executeUpdate();
	}
	
	public void delete(UUID id) throws SQLException {
		
		PreparedStatement psDelete = conn.prepareStatement("Delete from pessoa where id = ?");
		psDelete.setObject(1,id);
		psDelete.executeUpdate();	
	}	
	
	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
	}
	
	
	//------------------- SELECIONAR E CRIAR TABELA --------------
	
	public List<Pessoa> selectAll() throws SQLException{
		List<Pessoa> listPessoas = new ArrayList<>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("select id, codigo,nome from pessoa");
		while(rsPessoas.next()) {
			Pessoa pessoaRecuperada = new Pessoa(		
		        (UUID) rsPessoas.getObject("id"),
		        rsPessoas.getInt("codigo"),
		        rsPessoas.getString("nome"));
		  listPessoas.add(pessoaRecuperada);
		}
		return listPessoas;
	}
	
	public void createTable() throws SQLException {
		 conn.createStatement().execute(
	    		  "create table if not exists pessoa ("
	    		  + "id uuid not null primary key,"
	    		  + "codigo integer not null unique,"
	    		  + "nome varchar(255) not null"
	    		  + ")");
	      conn.createStatement().execute("delete from pessoa");
		}
	
}

