package treinamento.matheusfaxina.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaRepository {
	private Connection conn;
	private PreparedStatement psInsert;
	
	PessoaRepository(Connection connConstructor) {
		this.conn = connConstructor;
		try {
			this.psInsert = conn.prepareStatement("INSERT INTO pessoa(id, codigo, nome) VALUES(?, ?, ?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		return this.conn.prepareStatement(sql);
	}
	
	public void insertComPrepareStatementFora(Pessoa pessoa) throws SQLException {
		PreparedStatement psInsert = prepareStatement("INSERT INTO pessoa(id, codigo, nome) VALUES(?, ?, ?)");
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setObject(2, pessoa.getCodigo());
		psInsert.setObject(3, pessoa.getNome());
		psInsert.executeUpdate();
	}
	
	public void insertComPrepareStatementDentro(Pessoa pessoa) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, pessoa.getId());
		psInsert.setObject(2, pessoa.getCodigo());
		psInsert.setObject(3, pessoa.getNome());
		psInsert.executeUpdate();
	}

	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement psUpdate = conn.prepareStatement("UPDATE pessoa SET codigo = ?, nome = ? WHERE id =?");
		psUpdate.setObject(1, pessoa.getCodigo());
		psUpdate.setObject(2, pessoa.getNome());
		psUpdate.setObject(3, pessoa.getId());
		psUpdate.executeUpdate();
	}

	public void delete(Pessoa pessoa) throws SQLException {
		this.delete(pessoa.getId());
	}

	public void delete(UUID uuid) throws SQLException {
		PreparedStatement psDelete = conn.prepareStatement("DELETE FROM pessoa WHERE id = ?");
		psDelete.setObject(1, uuid);
		psDelete.executeUpdate();
	}

	public List<Pessoa> selectAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rsPessoas = conn.createStatement().executeQuery("SELECT id, codigo, nome FROM pessoa");

		while (rsPessoas.next()) {
			Pessoa pessoaRecuperada = new Pessoa((UUID) rsPessoas.getObject("id"), rsPessoas.getInt("codigo"),
					rsPessoas.getString("nome"));

			pessoas.add(pessoaRecuperada);
		}

		return pessoas;
	}

	public void createTable(String nomeDaTabela) throws SQLException {
		this.conn.createStatement().execute("DROP TABLE " + nomeDaTabela +"");
		this.conn.createStatement().execute("CREATE TABLE if not exists " + nomeDaTabela +" (id uuid not null primary key,"
				+ " codigo integer not null unique," + " nome varchar(255) not null)");
	}
}