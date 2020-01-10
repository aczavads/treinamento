package guscam.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpa {
//	private static Contrato contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 2, 15));
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			
//			manager.createQuery("delete from Contrato").executeUpdate();
//			manager.createNativeQuery("delete from contrato").executeUpdate();
			manager.createNamedQuery("delete_contrato").executeUpdate();
			
//			manager.persist(new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 20)));
//			manager.persist(contrato2);
//			
//			manager.remove(contrato2);
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

}
