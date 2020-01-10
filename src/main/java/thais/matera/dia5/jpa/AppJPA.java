package thais.matera.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJPA {
	private static Contrato contrato1;
	private static Contrato contrato2;
	
	static {
		try {
			contrato1 = new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 10), new CPF("387.389.969-87"));
			contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 1, 10), new CPF("387.389.969-87"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		ContratoRepository repo = new ContratoRepository(manager);
		
		try {
			manager.getTransaction().begin();
			
			repo.deleteAll();
//			repo.save(contrato1);
			repo.save(contrato2);
			repo.delete(contrato2);
			contrato1.setNumero(new InteiroPositivo(22));
//			repo.save(contrato1);
			contrato1.setNumero(new InteiroPositivo(60));
//			repo.save(contrato1);

			repo.findAll().forEach(System.out::println);
			
//			manager.createQuery("delete from Contrato").executeUpdate();
//			manager.createNativeQuery("delete from contrato").executeUpdate();
//			manager.persist(new Contrato(1, LocalDate.of(2020, 1, 10)));
//			manager.persist(new Contrato(2, LocalDate.of(2020, 1, 10)));
//			manager.createNamedQuery("delete_contrato").executeUpdate();
//			contrato1 = manager.merge(contrato1);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		
		System.out.println("Foi.");
	}
}
