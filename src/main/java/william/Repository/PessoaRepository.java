package william.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import william.JDBC.Pessoa;




public class PessoaRepository {
	
	private Connection conn;
	PreparedStatement psInsert;
	public PessoaRepository(Connection conn) throws SQLException {
		this.conn = conn;
		this.psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome)" + "values (?,?,?)");
	}
	
	public void insert(Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = conn.prepareStatement("insert into pessoa (id, codigo, nome)" + "values (?,?,?)");
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	public void insert1(Pessoa pessoa) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	public void createTable() throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa(" + "id UUID not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");

		conn.createStatement().execute("delete from pessoa");
	}
	
	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		psUpdate.setString(1, pessoa.getNome());
		psUpdate.setInt(2, pessoa.getCodigo());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
	}
	
	public void delete(UUID id) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?;");
		psDelete.setObject(1, id);
		psDelete.execute();
		
	}

	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());

	}
	
	public List<Pessoa> selectAll() throws SQLException {
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
}
