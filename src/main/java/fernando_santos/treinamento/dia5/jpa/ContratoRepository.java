package fernando_santos.treinamento.dia5.jpa;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository {
	
	EntityManager em;
	
	public ContratoRepository(EntityManager em) {
		this.em = em;
	}
	
	public List<Contrato> getAll() {
		return em.createQuery("from Contrato", Contrato.class).getResultList();
	}
	
	public Contrato findById(UUID id) {
		if(id == null) {
			throw new IllegalArgumentException("ID é obrigatório.");
		}
		return em.find(Contrato.class, id);
	}
	
	public Contrato save(Contrato contrato) {
//		if(contrato.getId() != null) {
		if(findById(contrato.getId()) != null) {
			return em.merge(contrato);
		} else {
			em.persist(contrato);
			return contrato;
		}
	}
	
	public void remove(UUID id) {
		Contrato contrato = findById(id);
		if(contrato != null) {
			em.remove(contrato);
		} else {
			throw new IllegalArgumentException("ID não encontrado para remover.");
		}
	}
	

}
