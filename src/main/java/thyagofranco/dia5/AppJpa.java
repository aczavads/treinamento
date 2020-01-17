package thyagofranco.dia5;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class AppJpa {

	private static Contrato contrato1 = null;
	private static Contrato contrato2 = null;
	private static EntityManagerFactory factory = null;
	private static EntityManager manager = null;
	
	static {
		try {
			contrato1 = new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 10), new CPF("645.584.603-68"));
			contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 1, 10), new CPF("489.666.236-97"));
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		try {
			

			manager.getTransaction().begin();

			// JPQL Operando sobre a classe Contrato
			// manager.createQuery("delete from Contrato").executeUpdate();

			// Utilizando query Nativa SQL
			// manager.createNativeQuery("delete from contrato").executeUpdate();

			// @NamedQuery
			manager.createNamedQuery("delete_contrato").executeUpdate();

			manager.persist(contrato1);
			manager.persist(contrato2);
			//manager.remove(contrato2);
			
			manager.createQuery("delete from Contrato c where c.id = :id")
				.setParameter("id", contrato2.getId())
				.executeUpdate();
				

		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();

		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

}
