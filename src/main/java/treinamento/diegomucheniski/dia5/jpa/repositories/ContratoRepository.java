package treinamento.diegomucheniski.dia5.jpa.repositories;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

import diegomucheniski.domains.Contrato;

public class ContratoRepository {	
	
	private EntityManager manager;
	
	public ContratoRepository(EntityManager manager) {	
		this.manager = manager;
	}
	
	public void save(Contrato contrato) {
		manager.persist(contrato);
	}
	
	public void delete(UUID id) {
		manager.createQuery("delete from Contrato contrato where contrato.id = :id").setParameter("id", id).executeUpdate();
	}
	
	public List<Contrato> findAll() {
		return manager.createQuery("select contrato from Contrato contrato", Contrato.class).getResultList();
	}


}
