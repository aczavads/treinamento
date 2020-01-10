package treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.impl;

import treinamento.dia4.jdbc.repo_generico.fernando.santos.domain.Grupo;
import treinamento.dia4.jdbc.repo_generico.fernando.santos.repository.GrupoRepository;

public class GrupoRepositoryImpl extends AbstractRepositoryImpl<Grupo> implements GrupoRepository {
	
	public GrupoRepositoryImpl() {
		super(Grupo.class);
	}

}
