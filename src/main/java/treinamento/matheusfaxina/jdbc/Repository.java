package treinamento.matheusfaxina.jdbc;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface Repository {
	
	List<Pessoa> selectAll() throws SQLException;
	void createTable(String nomeDaTabela) throws SQLException;
	void delete(Pessoa pessoa) throws SQLException;
	void delete(UUID uuid) throws SQLException;
	void update(Pessoa pessoa) throws SQLException;
	void insert(Pessoa pessoa) throws SQLException;

}
