package valdenir.junior.dia4.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PessoaRepository {
	private Connection conn;
	PreparedStatement pst;

	public PessoaRepository(Connection conn) {
		super();
		this.conn = conn;
		try {
			pst = conn.prepareStatement("insert into pessoa(id, codigo, nome) values (?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertPreparado(Pessoa pessoa) throws SQLException {
		pst.clearParameters();
		pst.setObject(1, pessoa.getId());
		pst.setInt(2, pessoa.getCodigo());
		pst.setString(3, pessoa.getNome());
		pst.executeUpdate();
	}

	public void insert(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("insert into pessoa(id, codigo, nome) values (?, ?, ?)");
		ps.setObject(1, pessoa.getId());
		ps.setInt(2, pessoa.getCodigo());
		ps.setString(3, pessoa.getNome());
		ps.executeUpdate();
	}

	public void update(Pessoa pessoa) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("update pessoa set nome = ?, codigo = ? where id = ?");
		ps.setString(1, pessoa.getNome());
		ps.setObject(2, pessoa.getCodigo());
		ps.setObject(3, pessoa.getId());
		ps.executeUpdate();
	}

	public void delete(Pessoa pessoa) throws SQLException {
		delete(pessoa.getId());
	}

	public void delete(UUID id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from pessoa where id = ?");
		ps.setObject(1, id);
		ps.executeUpdate();
	}

	public List<Pessoa> selectAll() throws SQLException {
		List<Pessoa> pessoas = new ArrayList<>();
		ResultSet rs = conn.createStatement().executeQuery("select id, codigo, nome from pessoa");
		while (rs.next()) {
			pessoas.add(new Pessoa((UUID) rs.getObject("id"), rs.getInt("codigo"), rs.getString("nome")));
		}

		return pessoas;
	}

	public void createTable() throws SQLException {
		conn.createStatement().execute("create table if not exists pessoa (id uuid not null primary key, "
				+ "codigo integer not null unique, nome varchar(255))");
		conn.createStatement().execute("delete from pessoa");
	}
}
