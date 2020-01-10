package valdenir.junior.dia5.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();

		try {
			manager.getTransaction().begin();

			// manager.createQuery("delete from Contrato").executeUpdate();
			// manager.createNativeQuery("delete from contrato").executeUpdate();
			manager.createNamedQuery("delete").executeUpdate();

			Contrato contrato = new Contrato(new InteiroPositivo(1), new CPF("165.113.120-11"), LocalDate.of(2020, 1, 15));
			manager.merge(contrato);

			// manager.remove(contrato);

			ContratoRepository contratoRepository = new ContratoRepository(manager);

			contratoRepository.selectAll().forEach(c -> System.out.println(c));
			System.out.println("----------------------------------------------------------");

			contrato.setNumero(new InteiroPositivo(25));
			contratoRepository.update(contrato);

			contratoRepository.selectAll().forEach(c -> System.out.println(c));
			System.out.println("----------------------------------------------------------");
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}
		System.out.println("FIM");
	}

}
