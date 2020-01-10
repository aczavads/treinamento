package GLF.dia5.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

public class RepositoryContrato {
	
	private EntityManager manager;
	
	public RepositoryContrato(EntityManager manager) {
		this.manager = manager;
	}
	
	public void save(Contrato contrato) {
		manager.persist(contrato);
		
	}
	public void delete(UUID id) {
		manager.createQuery("delete from Contrato c where c.id = :id")
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
