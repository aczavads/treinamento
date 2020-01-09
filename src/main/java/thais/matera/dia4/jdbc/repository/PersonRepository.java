package thais.matera.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import thais.matera.dia4.jdbc.Person;

public class PersonRepository {
	private PreparedStatement psInsert;
	private Connection conn;
	
	public PersonRepository(Connection conn) throws SQLException {
		this.conn = conn;
		this.psInsert = conn.prepareStatement("insert into person (id, code, name) values (?, ?, ?)");
	}
	
	public void insert(Person person) throws SQLException {
		PreparedStatement psInsert = 
				conn.prepareStatement("insert into person (id, code, name) values (?, ?, ?)");
		psInsert.setObject(1, person.getId());
		psInsert.setObject(2, person.getCode());
		psInsert.setObject(3, person.getName());
		psInsert.executeUpdate();
	}
	
	public void insertSmart(Person person) throws SQLException {
		psInsert.clearParameters();
		psInsert.setObject(1, person.getId());
		psInsert.setObject(2, person.getCode());
		psInsert.setObject(3, person.getName());
		psInsert.executeUpdate();
	}
	
	public void update(Person person) throws SQLException {
		PreparedStatement psUpdate =
				conn.prepareStatement("update person set "
						+ "id = ?,"
						+ "code = ?,"
						+ "name = ?"
						+ " where id = ?");
		psUpdate.setObject(1, person.getId());
		psUpdate.setObject(2, person.getCode());
		psUpdate.setObject(3, person.getName());
		psUpdate.setObject(4, person.getId());
		psUpdate.executeUpdate();
	}
	
	public void delete(Person person) throws SQLException {
		delete(person.getId());
	}
	
	public void delete(UUID id) throws SQLException {
		PreparedStatement psDelete = 
				conn.prepareStatement("delete from person where id = ?");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
	}
	
	public List<Person> selectAll() throws SQLException {
		List<Person> people = new ArrayList<>();
		
		ResultSet rsPeople = conn.createStatement().executeQuery("select id, code, name from person");
		
		while(rsPeople.next()) {
			UUID idReturned = (UUID) rsPeople.getObject("id");
			Integer codeReturned = rsPeople.getInt("code");
			String nameReturned = rsPeople.getString("name");
			
			Person returned = new Person(idReturned, codeReturned, nameReturned);
			
			people.add(returned);
		}
				
		return people;
	}
	
	public void createTable() throws SQLException {
		conn.createStatement().execute("create table if not exists person "
				+ "("
				+ "id uuid not null primary key,"
				+ "code integer not null unique,"
				+ "name varchar(255) not null"
				+ ")");
		conn.createStatement().execute("delete from person");
	}
}