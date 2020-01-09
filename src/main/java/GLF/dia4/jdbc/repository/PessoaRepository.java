package GLF.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

public class PessoaRepository {
	private Connection conn;
	private PreparedStatement psInsert;
	public PessoaRepository( Connection conn) {
		this.conn = conn;
		try {
			psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	public void createTable() throws SQLException { 
		conn.createStatement().execute("create table if not exists pessoa ("
				+ "id uuid not null primary key,"
				+"codigo integer not null unique,"
				+ "nome varchar(255) not null" 
				+ ")" );
		
		conn.createStatement().execute("delete from pessoa");
		
	}
	
	public void insert(Pessoa pessoa) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	public void insertComCashDePreparo(Pessoa pessoa) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
		
	}
	public void update( Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
		
	}
	public void delete( UUID id ) throws SQLException {
		
		PreparedStatement psDelete = conn.prepareStatement("delete from pessoa where id = ? ");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
	}
	
	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
		
	}
	
	public List<Pessoa> selectAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoa = conn.createStatement().executeQuery("select * from pessoa");
		
		while (rsPessoa.next()) {
			UUID idRecuperado = (UUID)rsPessoa.getObject("id");
			String nomeRecuperado = rsPessoa.getString("nome");
			Integer codigoRecuperado = rsPessoa.getInt("codigo");
			
			Pessoa recuperada = new Pessoa (idRecuperado, codigoRecuperado, nomeRecuperado);
			pessoas.add(recuperada);
		}
		return pessoas;
	}


	
	
	
}
