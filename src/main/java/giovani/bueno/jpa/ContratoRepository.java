package giovani.bueno.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;


public class ContratoRepository {
  
	private EntityManager manager;

	public ContratoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public void inserirContrato(Contrato contrato) {
		manager.persist(contrato);
	}
	
	public void editarContrato(Contrato contrato) {
		manager.createQuery("update Contrato c set c.numero = :numero,c.emissao = :emissao where c.id =:id")
		.setParameter("id", contrato.getId())
		.setParameter("numero",contrato.getNumero())
		.setParameter("emissao", contrato.getEmissao())
		.executeUpdate();
	}
	
	public void deleteContrato(UUID id) {
		manager.createQuery("delete from Contrato c where c.id =:id")
		.setParameter("id", id)
		.executeUpdate();
	}
	
	public List<Contrato> selectAllContratos(){
		List<Contrato> listContrato = new ArrayList<Contrato>();
         listContrato = manager.createQuery("select c from Contrato c",Contrato.class)
				.getResultList();
	    return listContrato;
	}
	
}
