package schiavon.gabriel.dia5.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository {

	private EntityManager entityManager;

	public ContratoRepository(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public void insertOrUpdate(Object data) {
		entityManager.persist(data);
	}

	public void delete(Object data) {
		entityManager.remove(data);
	}

	public void delete(UUID id) {
		Contrato contrato = entityManager.find(Contrato.class, id);
		if (contrato != null) {
			entityManager.remove(contrato);
		}
	}

	public List<Contrato> selectAll() {
		return entityManager
				.createQuery("select c from Contrato c", Contrato.class)
				.getResultList();
	}
	
	public void deleteAll() {
		entityManager.createQuery("delete from Contrato").executeUpdate();
	}
	
}
