package GLF.dia5.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



public class AppJpa {
	private static Contrato contrato1;
	private static Contrato contrato2;
	
	static {
		try {
			contrato1 =  new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 10), new CPF("104.291.049-95"));
			contrato2  = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 1, 10), new CPF("811.538.729-00"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		
		try {
			
			manager.getTransaction().begin();			
			//manager.createQuery("delete from Contrato").executeUpdate();
			//manager.createNativeQuery("delete from Contrato").executeUpdate();
			manager.createNamedQuery("delete_contrato").executeUpdate();
			manager.persist(contrato1);
			manager.persist(contrato2);
			
			/*manager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Veja no banco");
			manager.getTransaction().begin();
			manager.remove(contrato2);*/
			
			manager.createQuery("delete from Contrato c where c.id = :id")
			.setParameter("id", contrato2.getId())
			.executeUpdate();
			
			List<Contrato> contratos = manager.createQuery("select c from Contrato c", Contrato.class).getResultList();
			contrato1 = manager.merge(contrato1);
			manager.persist(contrato1);
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.getTransaction().commit();
		}
		
		
		System.out.println("Foi.");

	}

}
