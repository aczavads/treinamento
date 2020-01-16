package fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.impl;

import fernando_santos.treinamento.dia4.jdbc.repo_generico.domain.Produto;
import fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.ProdutoRepository;

public class ProdutoRepositoryImpl extends AbstractRepositoryImpl<Produto> implements ProdutoRepository {

	public ProdutoRepositoryImpl() {
		super(Produto.class);
	}

}
