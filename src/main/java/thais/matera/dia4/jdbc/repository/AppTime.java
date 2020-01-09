package thais.matera.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import thais.matera.dia4.jdbc.Person;

public class AppTime {
	
	public static void main(String[] args) {
		System.out.println("running...");
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			PersonRepository personR = new PersonRepository(conn);
			conn.setAutoCommit(false);
			personR.createTable();
			
			long beginA = System.currentTimeMillis();
			runInsert(personR);
			conn.commit();
			System.out.println("time(ms): " + (System.currentTimeMillis()-beginA));

			personR.createTable();
			conn.commit();
			
			long beginB = System.currentTimeMillis();
			runSmartInsert(personR);
			conn.commit();
			System.out.println("time(ms): " + (System.currentTimeMillis()-beginB));			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	private static void runInsert(PersonRepository repo) throws SQLException {
		for(int i = 1; i <= 1000; i++) {
			Person person = new Person(i, "Anônimo");
			repo.insert(person);
		}
	}
	
	private static void runSmartInsert(PersonRepository repo) throws SQLException {
		for(int i = 0; i <= 1000; i++) {
			Person person = new Person(i, "Anônimo");
			repo.insertSmart(person);
		}
	}
}
