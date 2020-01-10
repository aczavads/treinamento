package guscam.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpaRepository {
	private static Contrato contrato1 = new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 1, 25), new Cpf("074.739.519-55"));
	private static Contrato contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 2, 15), new Cpf("547....................983.379-00"));

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("pu");
			manager = factory.createEntityManager();

			manager.getTransaction().begin();
			manager.createNamedQuery("delete_contrato").executeUpdate();

			ContratoRepository repo = new ContratoRepository(manager);

			repo.save(contrato1);
			repo.save(contrato2);
			contrato2.setNumero(new InteiroPositivo(15));
			repo.delete(contrato1);
			
			repo.findAll().forEach(System.out::println);

			
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

}
