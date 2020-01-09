package guscam.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaRepository {

	private Connection connection;
	private PreparedStatement psInsert;

	public PessoaRepository(Connection connection) throws SQLException {
		this.connection = connection;
		this.psInsert = connection.prepareStatement("insert into pessoa (id, codigo, nome) values(?,?,?)");
	}

	public List<Pessoa> selectAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rsPessoas = connection.createStatement().executeQuery("select id, codigo, nome from pessoa");
		while (rsPessoas.next()) {
			Pessoa pessoaSelecionada = new Pessoa((UUID) rsPessoas.getObject("id"), rsPessoas.getInt("codigo"),
					rsPessoas.getString("nome"));
			pessoas.add(pessoaSelecionada);
		}
		return pessoas;
	}

	public void delete(UUID id) throws SQLException {
		PreparedStatement psDelete = connection.prepareStatement("delete from pessoa where id = ?");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
	}

	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
	}

	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = connection.prepareStatement("update pessoa set codigo = ?, nome = ? where id = ?");
		psUpdate.setInt(1, pessoa.getCodigo());
		psUpdate.setString(2, pessoa.getNome());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
	}

	public void insert(Pessoa pessoa) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setInt(2, pessoa.getCodigo());
		psInsert.setString(3, pessoa.getNome());
		psInsert.executeUpdate();
	}

	public void createTable() throws SQLException {
		connection.createStatement().execute("create table if not exists pessoa (id uuid not null primary key,"
				+ "codigo integer not null unique," + "nome varchar(255) not null" + ")");
		connection.createStatement().execute("delete from pessoa");
	}

}
