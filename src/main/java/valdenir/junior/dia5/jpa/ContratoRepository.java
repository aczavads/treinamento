package valdenir.junior.dia5.jpa;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;

public class ContratoRepository {
	private EntityManager em;

	public ContratoRepository(EntityManager em) {
		this.em = em;
	}

	public void insert(Contrato entity) {
		em.persist(entity);
	}

	public void update(Contrato entity) {
		em.merge(entity);
	}

	public void delete(Contrato entity) {
		delete(entity.getId());
	}

	public void delete(UUID id) {
		em.createNativeQuery("delete from contrato where id = :id").setParameter("id", id).executeUpdate();
	}

	public List<Contrato> selectAll() {
		return em.createQuery("from Contrato", Contrato.class).getResultList();
	}
}
