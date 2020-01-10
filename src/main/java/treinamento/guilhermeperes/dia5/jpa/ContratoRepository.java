package treinamento.guilhermeperes.dia5.jpa;

import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository extends SQLRepository<Contrato, UUID> {
	public ContratoRepository(EntityManager manager) {
		super(manager);
	}
}
