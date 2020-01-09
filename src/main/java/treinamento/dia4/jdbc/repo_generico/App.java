package treinamento.dia4.jdbc.repo_generico;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

public class App {
	private static final Produto omo = new Produto("Omo Progress");
	private static final Grupo grupoLegal = new Grupo("Grupo legal", LocalDate.of(2020, 1, 15));

	public static void main(String[] args) throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		//RepositorioGenerico<Produto> repoProduto = new RepositorioGenerico<>(conn, Produto.class);
		//RepositorioGenerico<Grupo> repoGrupo = new RepositorioGenerico<>(conn, Grupo.class);
		RepositorioGenerico<ProdutoBonificado> repoProdutoBonificado = new RepositorioGenerico<>(conn, ProdutoBonificado.class);

		//System.out.println(Produto.class.isAssignableFrom(Entidade.class));
		//System.out.println(Entidade.class.isAssignableFrom(Produto.class));
		//repoProduto.insert(omo);
		// repoGrupo.insert(grupoLegal);
		System.out.println("Foi.");

	}

}
