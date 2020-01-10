package thais.matera.dia5.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository {
	private EntityManager manager;

	public ContratoRepository(EntityManager entityManager) {
		this.manager = entityManager;
	}
	
	public void save(Contrato contato) {
		this.manager.persist(contato);
	}
	
	public void deleteAll() {
		this.manager.createNamedQuery("delete_contrato").executeUpdate();
	}
	
	public void delete(Contrato contrato) {
		this.delete(contrato.getId());
	}
	
	public void delete(UUID id) {
		manager.createQuery("delete from Contrato c where c.id = :id")
		.setParameter("id", id)
		.executeUpdate();		
	}
	
	
	public List<Contrato> findAll() {
		return manager.createQuery("select c from Contrato c", Contrato.class).getResultList();
	}
}
