package fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.impl;

import fernando_santos.treinamento.dia4.jdbc.repo_generico.domain.ProdutoBonificado;
import fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.ProdutoBonificadoRepository;

public class ProdutoBonificadoRepositoryImpl extends AbstractRepositoryImpl<ProdutoBonificado>
		implements ProdutoBonificadoRepository {

	public ProdutoBonificadoRepositoryImpl() {
		super(ProdutoBonificado.class);
	}

}
