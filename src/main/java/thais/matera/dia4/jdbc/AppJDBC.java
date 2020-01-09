package thais.matera.dia4.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.JOptionPane;

public class AppJDBC {
	private static final Person rachael = new Person(1, "Rachael Garde");
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
			
			rachael.setName("Rachael");
			updatePerson(conn, rachael);
			deletePerson(conn, ross);
			
			JOptionPane.showMessageDialog(null, "Transaction running...");
			
			conn.commit();
		} catch (Exception err) {
			throw new RuntimeException(err);
		}
		
		System.out.println("connected");
	}
	
	private static void deletePerson(Connection conn, Person person) throws SQLException {
		PreparedStatement psDelete = 
				conn.prepareStatement("delete from person where id = ?");
		psDelete.setObject(1, person.getId());
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
