package treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.impl;

import treinamento.dia4.jdbc.repo_generico.fernando.santos.domain.ProdutoBonificado;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.ProdutoBonificadoRepository;

public class ProdutoBonificadoRepositoryImpl extends AbstractRepositoryImpl<ProdutoBonificado>
		implements ProdutoBonificadoRepository {

	public ProdutoBonificadoRepositoryImpl() {
		super(ProdutoBonificado.class);
	}

}
