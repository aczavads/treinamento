package thais.matera.dia4.jdbc.repogeneric;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class App {
	private static final Product omo = new Product("Omo Progress");
	private static final Group groupNice = new Group("Grupo nice", LocalDate.of(2020, 1, 15));
	
	public static void main(String[] args) throws Exception {
		
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
			GenericRepository<Product> repoProduct = new GenericRepository<>(conn, Product.class);
			GenericRepository<Group> repoGroup = new GenericRepository<>(conn, Group.class);
			repoProduct.insert(omo);
			repoGroup.insert(groupNice);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
