package treinamento.dia5.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class AppJpa {
	private static Contrato contrato1 = new Contrato(
			new InteiroPositivo(1), LocalDate.of(2020, 1, 10),
			new CPF("242.798.315-21"));
	
	private static Contrato contrato2 = new Contrato(
			new InteiroPositivo(2), LocalDate.of(2020, 1, 10),
			new CPF("515.107.071-15"));
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();			
			//manager.createQuery("delete from Contrato").executeUpdate();
			//manager.createNativeQuery("delete from contrato").executeUpdate();
			manager.createNamedQuery("delete_contrato").executeUpdate();
			manager.persist(contrato1);
			manager.persist(contrato2);
			//manager.remove(contrato2);
			manager.createQuery("delete from Contrato c where c.id = :id")
				.setParameter("id", contrato2.getId())
				.executeUpdate();
			List<Contrato> contratos = manager
					.createQuery("select c from Contrato c", Contrato.class).getResultList();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		
		System.out.println("Foi.");
	}

}
