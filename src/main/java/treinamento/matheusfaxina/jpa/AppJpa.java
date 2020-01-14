package treinamento.matheusfaxina.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpa {

	private static Contrato contrato1 = new Contrato(new InteiroPositivo(1), LocalDate.of(2020, 01, 10), new Cpf("3825"));
	private static Contrato contrato2 = new Contrato(new InteiroPositivo(2), LocalDate.of(2020, 10, 10), new Cpf("38940699025"));

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
		EntityManager manager = factory.createEntityManager();
		RepositoryJpa repositoryJpa = new RepositoryJpa(manager);

		try {
			manager.getTransaction().begin();

//			manager.createQuery("DELETE FROM Contrato").executeUpdate();
//			manager.createNativeQuery("DELETE FROM contrato").executeUpdate();
			manager.createNamedQuery("delete_contrato").executeUpdate();
			repositoryJpa.insert(contrato1);
			repositoryJpa.merge(contrato2);

//			repositoryJpa.delete(contrato2);

			contrato2.setEmissao(LocalDate.now());
			// repositoryJpa.delete(contrato2);
			repositoryJpa.update(contrato2);

			List<Contrato> contratos = repositoryJpa.listAll();
			contratos.forEach(contrato -> System.out
					.println("Contrato: " + contrato.getNumero() + " com a data de emissão: " + contrato.getEmissao()));

			repositoryJpa.merge(contrato2);
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			manager.getTransaction().commit();
		}

		System.out.println("Foi.");
	}

}
