package william.dia4.RepositoryGenerico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class AppGenerics {
	private static Grupo grupo1 = new Grupo("grupo aleatorio", LocalDate.now());
	Produto produto1 = new Produto("Caneca de café");
	
	public static void main(String[] args) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			RepositorioGenerico<Grupo> repoGrupo = new RepositorioGenerico<>(conn, Grupo.class);
			System.out.println(repoGrupo.gerarSelectDe());
			System.out.println(repoGrupo.gerarDeleteDe());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
