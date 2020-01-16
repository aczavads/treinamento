package william.dia5;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository {
	private EntityManager manager;

	public ContratoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void Insert(Contrato contrato) {
		manager.persist(contrato);
	}
	
	public void Delete(UUID id) {
		manager.createQuery("delete from Contrato c where c.id = :id")
		.setParameter("id", id)
		.executeUpdate();
	}
	public void Delete(Contrato contrato) {
		
		Delete(contrato.getId());
	}
	
	public List<Contrato> selectAll(){
		return manager.createQuery("select c from Contrato c", Contrato.class).getResultList();
	}
	
	public void update(Contrato contrato) {
		manager.merge(contrato);
	}

	public void clearAll() {
		manager.createNamedQuery("delete_contrato").executeUpdate();
		
	}
}
