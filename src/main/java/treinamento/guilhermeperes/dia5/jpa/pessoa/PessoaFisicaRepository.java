package treinamento.guilhermeperes.dia5.jpa.pessoa;

import java.util.UUID;

import javax.persistence.EntityManager;

import treinamento.guilhermeperes.dia5.jpa.base.SQLRepository;

public class PessoaFisicaRepository extends SQLRepository<PessoaFisica, UUID>{

	public PessoaFisicaRepository(EntityManager manager) {
		super(manager);
	}
}
