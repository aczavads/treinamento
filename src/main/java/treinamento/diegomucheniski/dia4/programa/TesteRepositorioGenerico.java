package treinamento.diegomucheniski.dia4.programa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

import treinamento.diegomucheniski.dia4.repositories.RepositorioGenerico;
import treinamento.diegomucheniski.domains.Grupo;
import treinamento.diegomucheniski.domains.Produto;
import treinamento.diegomucheniski.domains.ProdutoBonificado;

public class TesteRepositorioGenerico {
	
	private static final Produto omo = new Produto("Omo Progress");
	private static final Grupo grupoLegal = new Grupo("Grupo legal", LocalDate.of(2020, 1, 15));

	public static void main(String[] args) throws Exception {
		try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
			//RepositorioGenerico<Produto> repoProduto = new RepositorioGenerico<>(conn, Produto.class);
			//RepositorioGenerico<Grupo> repoGrupo = new RepositorioGenerico<>(conn, Grupo.class);
			RepositorioGenerico<ProdutoBonificado> repoProdutoBonificado = new RepositorioGenerico<>(conn, ProdutoBonificado.class);

			//System.out.println(Produto.class.isAssignableFrom(Entidade.class));
			//System.out.println(Entidade.class.isAssignableFrom(Produto.class));
			//repoProduto.insert(omo);
			// repoGrupo.insert(grupoLegal);
		}
		System.out.println("Foi.");		

	}

}
