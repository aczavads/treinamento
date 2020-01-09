package schiavon.gabriel.dia4.JDBC.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface BaseRepository<T> {

	public void createTable() throws SQLException;
	public void insert(T data) throws SQLException;
	public void update(T data) throws SQLException;
	public void delete(T data) throws SQLException;
	public void delete(UUID id) throws SQLException;
	public List<T> selectAll() throws SQLException;
	
}
