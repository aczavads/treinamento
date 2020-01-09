package schiavon.gabriel.dia4.JDBC.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaRepository implements BaseRepository<Pessoa> {

	private final Connection conn;
	
	public PessoaRepository(Connection conn) {
		this.conn = conn;
	}

	public void createTable() throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa (id uuid not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");
		conn.createStatement().execute("delete from pessoa");
	}
	
	public void insertSemPreparedStatement() throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		for (int i=0; i < 10000; i++) {
			alteraValoresPS(new Pessoa(i, ("Nome" + i)), psInsert);
			MyConnection.getInstance().commit();
		}
	}

	private void alteraValoresPS(Pessoa pessoa, PreparedStatement psInsert) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());

		psInsert.executeUpdate();
	}
	
	public void insert(Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome) values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());

		psInsert.executeUpdate();
	}
	
	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set codigo=?,nome=? where id=?");
		psUpdate.setInt(1, pessoa.getCodigo());
		psUpdate.setString(2, pessoa.getNome());
		psUpdate.setObject(3, pessoa.getId());

		psUpdate.executeUpdate();
	}
	
	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
	}

	public void delete(UUID id) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("delete from pessoa where id=?");
		psDelete.setObject(1, id);

		psDelete.execute();
	}
	
	public List<Pessoa> selectAll() throws SQLException {
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

	public void deleteAll() throws SQLException {
		conn.createStatement().execute("delete from pessoa");
	}
	
}
