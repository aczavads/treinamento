package treinamento.guilhermeperes.dia5.jpa.conta;

import java.util.UUID;

import javax.persistence.EntityManager;

import treinamento.guilhermeperes.dia5.jpa.base.SQLRepository;

public class ContaRepository extends SQLRepository<Conta, UUID>{

	public ContaRepository(EntityManager manager) {
		super(manager);
	}
}
