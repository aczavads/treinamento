package valdenir.junior.dia4.jdbc;

import java.time.LocalDate;

public class AppGeneric {
	private static final Produto omo = new Produto("omo progress");
	private static final Grupo grupoLegal = new Grupo("Grupo Legal", LocalDate.of(2020, 1, 15));

	public static void main(String[] args) {
		RepositoryGenerico<SubProduto> repoProduto = new RepositoryGenerico<>(SubProduto.class);
		RepositoryGenerico<Grupo> grupoProduto = new RepositoryGenerico<>(Grupo.class);

		repoProduto.insert(new SubProduto("", ""));
//		grupoProduto.insert(grupoLegal);
	}
}
