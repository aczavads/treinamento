package treinamento.dia5.jpa.repository;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import treinamento.dia5.jpa.Contrato;

public class ContratoRepository {
	private EntityManager manager;

	public ContratoRepository(EntityManager manager) {
		this.manager = manager;
	}
	public void save(Contrato contrato) {
		//manager.persist(manager.merge(contrato));
		manager.persist(contrato);
	}
	public void delete(UUID id) {
		manager
			.createQuery("delete from Contrato c where c.id = :id")
			.setParameter("id", id)
			.executeUpdate();
	}
	public void delete(Contrato contrato) {
		delete(contrato.getId());
	}
	public List<Contrato> findAll() {
		return manager.createQuery("select c from Contrato c", Contrato.class).getResultList();
	}

}












