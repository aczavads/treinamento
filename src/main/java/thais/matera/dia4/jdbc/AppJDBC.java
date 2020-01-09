package thais.matera.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AppJDBC {
	private static final Person rachael = new Person(1, "Rachel Greene");
	private static final Person monica = new Person(2, "Monica");
	private static final Person ross = new Person(3, "Ross");
	
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
			createTablePerson(conn);
			
			conn.setAutoCommit(false);
			
			insertPerson(conn, rachael);
			insertPerson(conn, monica);
			insertPerson(conn, ross);
			
			rachael.setName("Rachel");
			
			updatePerson(conn, rachael);
			deletePerson(conn, ross);
			deletePerson(conn, monica.getId());
					
			conn.commit();
			
			List<Person> people = selectAll(conn);
			showAllPerson(people);

		} catch (Exception err) {
			throw new RuntimeException(err);
		}
		
		System.out.println("connected");
	}
	
	private static void showAllPerson(List<Person> people) {
		people.forEach(p -> System.out.println(p.toString()));
	}

	private static List<Person> selectAll(Connection conn) throws SQLException {
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

	private static void deletePerson(Connection conn, Person person) throws SQLException {
		deletePerson(conn, person.getId());
	}
	
	private static void deletePerson(Connection conn, UUID id) throws SQLException {
		PreparedStatement psDelete = 
				conn.prepareStatement("delete from person where id = ?");
		psDelete.setObject(1, id);
		psDelete.executeUpdate();
	}

	private static void updatePerson(Connection conn, Person person) throws SQLException {
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

	private static void insertPerson(Connection conn, Person person) throws SQLException {
		PreparedStatement psInsert = 
				conn.prepareStatement("insert into person (id, code, name) values (?, ?, ?)");
		psInsert.setObject(1, person.getId());
		psInsert.setObject(2, person.getCode());
		psInsert.setObject(3, person.getName());
		psInsert.executeUpdate();
	}

	private static void createTablePerson(Connection conn) throws SQLException {
		conn.createStatement().execute("create table if not exists person "
				+ "("
				+ "id uuid not null primary key,"
				+ "code integer not null unique,"
				+ "name varchar(255) not null"
				+ ")");
		conn.createStatement().execute("delete from person");
	}
}
