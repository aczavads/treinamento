package FelipeSilva.jdbc.repo_generico;

import java.time.LocalDate;

public class App {

	private static final Produto omo = new Produto("Omo Progress");
	private static final Grupo grupoLegal = new Grupo("Grupo legal", LocalDate.of(2020, 1, 15));

	public static void main(String[] args) {
		RepositorioGenerico<Produto> repoProduto = new RepositorioGenerico(Produto.class);
		RepositorioGenerico<Grupo> repoGrupo = new RepositorioGenerico(Grupo.class);

		repoProduto.insert(omo);
		repoGrupo.insert(grupoLegal);

	}
}
