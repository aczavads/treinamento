package fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.impl;

import fernando_santos.treinamento.dia4.jdbc.repo_generico.domain.Grupo;
import fernando_santos.treinamento.dia4.jdbc.repo_generico.repository.GrupoRepository;

public class GrupoRepositoryImpl extends AbstractRepositoryImpl<Grupo> implements GrupoRepository {
	
	public GrupoRepositoryImpl() {
		super(Grupo.class);
	}

}
