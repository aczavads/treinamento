package GLF.dia5.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpaRepository {
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
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();
			
			manager.getTransaction().begin();	
			manager.createQuery("delete from Contrato").executeUpdate();
			
			RepositoryContrato repo = new RepositoryContrato(manager);
			repo.save(contrato1);
			repo.save(contrato2);
			contrato2.setNumero(new InteiroPositivo(22));
			repo.save(contrato2);
			//repo.delete(contrato1.getId());
			repo.delete(contrato1);
			repo.findAll().stream().forEach(System.out::println);
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			manager.getTransaction().commit();
		}
		
		
		System.out.println("Foi.");

	}
}
