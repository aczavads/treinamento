package treinamento.guilhermeperes.dia5.jpa.pessoa;

import java.util.UUID;

import javax.persistence.EntityManager;

import treinamento.guilhermeperes.dia5.jpa.base.SQLRepository;

public class PessoaJuridicaRepository extends SQLRepository<PessoaJuridica, UUID>{

	public PessoaJuridicaRepository(EntityManager manager) {
		super(manager);
	}
}
