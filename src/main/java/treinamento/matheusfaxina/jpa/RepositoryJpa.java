package treinamento.matheusfaxina.jpa;

import java.util.List;

import javax.persistence.EntityManager;

public class RepositoryJpa {
	
	private EntityManager manager;
	
	public RepositoryJpa(EntityManager manager) {
		this.manager = manager;
	}

	public void delete(Contrato contrato) {
		manager.createQuery("DELETE FROM Contrato c WHERE c.id = :id")
		.setParameter("id", contrato.getId())
		.executeUpdate();
	}

	public void insert(Contrato contrato) {
		manager.persist(contrato);
	}
	
	public void update(Contrato contrato) {
		manager.createQuery("UPDATE Contrato c SET c.numero = :numero, c.emissao = :emissao WHERE c.id = :id")
		.setParameter("numero", contrato.getNumero())
		.setParameter("emissao", contrato.getEmissao())
		.setParameter("id", contrato.getId())
			.executeUpdate();
	}

	public List<Contrato> listAll() {
		return manager.createQuery("SELECT c FROM Contrato c", Contrato.class).getResultList();
	}
	
	public void merge(Contrato contrato) {
		manager.merge(contrato);
	}

}
