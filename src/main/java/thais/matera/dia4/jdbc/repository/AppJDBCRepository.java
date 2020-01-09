package thais.matera.dia4.jdbc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import thais.matera.dia4.jdbc.Person;

public class AppJDBCRepository {
	private static final Person rachel = new Person(1, "Rachel Greene");
	private static final Person monica = new Person(2, "Monica");
	private static final Person ross = new Person(3, "Ross");
	
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			
			PersonRepository personR = new PersonRepository(conn);
			
			personR.createTable();
			
			conn.setAutoCommit(false);
			
			personR.insert(rachel);
			personR.insert(monica);
			personR.insert(ross);
			
			rachel.setName("Rachel");
			
			personR.update(rachel);
			personR.delete(ross);
			
			conn.commit();
			
			List<Person> people = personR.selectAll();
			people.forEach(p -> System.out.println(p.toString()));
			
			System.out.println("connected");
		} catch (Exception err) {
			throw new RuntimeException(err);
		}
	}
}
