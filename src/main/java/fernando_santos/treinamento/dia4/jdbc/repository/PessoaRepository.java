package fernando_santos.treinamento.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fernando_santos.treinamento.dia4.jdbc.repository.Pessoa;

public class PessoaRepository {
	
	private final Connection connection;
	private PreparedStatement preparedStatementInsert;

	public PessoaRepository(Connection connection) throws SQLException {
		this.connection = connection;
//		createTable();
		this.preparedStatementInsert = connection.prepareStatement("insert into pessoa (id, codigo, nome) values (?, ?, ?)");
	}
	
	public void insert(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = preparedStatementInsert;
		ps.clearParameters();
		ps.setObject(1, pessoa.getId());
		ps.setInt(2, pessoa.getCodigo());
		ps.setString(3, pessoa.getNome());
		ps.executeUpdate();
	}
	
	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		ps.setString(1, pessoa.getNome());
		ps.setInt(2, pessoa.getCodigo());
		ps.setObject(3, pessoa.getId());
		ps.executeUpdate();
	}
	
	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
	}

	public void delete(UUID id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement("delete from pessoa where id = ?");
		ps.setObject(1, id);
		ps.execute();
	}
	
	public List<Pessoa> selectAll() throws SQLException {
		ResultSet rs = connection.createStatement().executeQuery("select id, codigo, nome from pessoa");
		List<Pessoa> pessoas = new ArrayList<>();
		while (rs.next()) {
			Pessoa pessoaRecuperada = new Pessoa((UUID) rs.getObject("id"), rs.getInt("codigo"), rs.getString("nome"));
			pessoas.add(pessoaRecuperada);
		}
		return pessoas;
	}
	
	public void createTable() throws SQLException {
		connection.createStatement().execute(
				"create table if not exists pessoa (" + 
				"id uuid not null primary key," +
				"codigo integer not null unique," + 
				"nome varchar(255) not null)");
	}

}
