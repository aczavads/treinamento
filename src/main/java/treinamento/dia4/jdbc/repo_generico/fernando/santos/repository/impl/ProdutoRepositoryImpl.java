package treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.impl;

import treinamento.dia4.jdbc.repo_generico.fernando.santos.domain.Produto;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.ProdutoRepository;

public class ProdutoRepositoryImpl extends AbstractRepositoryImpl<Produto> implements ProdutoRepository {

	public ProdutoRepositoryImpl() {
		super(Produto.class);
	}

}
