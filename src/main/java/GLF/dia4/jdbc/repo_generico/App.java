package GLF.dia4.jdbc.repo_generico;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class App {
	private static final Produto omo = new Produto("Omo Progress");
	private static final Grupo grupoLegal = new Grupo("GrupoLegal", LocalDate.of(2020, 1, 15));
 
	public static void main(String[] args) {
		//Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		//RepositorioGenerico<Produto> repoProduto = new RepositorioGenerico<>(Produto.class);
		//RepositorioGenerico<Grupo> repoGrupo = new RepositorioGenerico<>(Grupo.class);
		
		//repoProduto.insert(omo);
		//repoGrupo.insert(grupoLegal);
	}
	
	
}
